import os
import secrets
from PIL import Image
from flask import render_template, url_for, flash, redirect, request, abort
from app import app, db, bcrypt
from app.forms import RegistrationForm, LoginForm, UpdateAccountForm, articuloForm
from app.models import User, Articulo
from flask_login import login_user, current_user, logout_user, login_required


@app.route("/")
@app.route("/home")
def home():
    articulos = Articulo.query.filter_by(user_id=current_user.id).order_by("fecha_caducidad").limit(5)
    return render_template('home.html', articulos=articulos)

@app.template_filter()
def dateFormat(fecha):
    return fecha.strftime('%d/%m/%Y')

@app.route("/about")
def about():
    return render_template('about.html', title='About')


@app.route("/register", methods=['GET', 'POST'])
def register():
    if current_user.is_authenticated:
        return redirect(url_for('home'))
    form = RegistrationForm()
    if form.validate_on_submit():
        hashed_password = bcrypt.generate_password_hash(form.password.data).decode('utf-8')
        user = User(username=form.username.data, email=form.email.data, nombre=form.nombre.data, apellido=form.apellido.data, password=hashed_password)
        db.session.add(user)
        db.session.commit()
        flash('Su cuenta ha sido creada! Ya puede hacer login', 'success')
        return redirect(url_for('login'))
    return render_template('register.html', title='Register', form=form)


@app.route("/login", methods=['GET', 'POST'])
def login():
    if current_user.is_authenticated:
        return redirect(url_for('home'))
    form = LoginForm()
    if form.validate_on_submit():
        user = User.query.filter_by(email=form.email.data).first()
        if user and bcrypt.check_password_hash(user.password, form.password.data):
            login_user(user, remember=form.remember.data)
            return redirect(url_for('home'))
        else:
            flash('Login fallido. Compruebe email y contraseña', 'danger')
    return render_template('login.html', title='Login', form=form)


@app.route("/logout")
def logout():
    logout_user()
    return redirect(url_for('login'))


@app.route("/account", methods=['GET', 'POST'])
@login_required
def account():
    form = UpdateAccountForm()
    if form.validate_on_submit():
        current_user.username = form.username.data
        current_user.email = form.email.data
        current_user.nombre = form.nombre.data
        current_user.apellido = form.apellido.data
        db.session.commit()
        flash('Tu cuenta ha sido actualizada!', 'success')
        return redirect(url_for('account'))
    elif request.method == 'GET':
        form.username.data = current_user.username
        form.email.data = current_user.email
        form.nombre.data = current_user.nombre
        form.apellido.data = current_user.apellido
    return render_template('account.html', title='Account', form=form)


@app.route("/articulo/new", methods=['GET', 'POST'])
@login_required
def new_articulo():
    form = articuloForm()
    if form.validate_on_submit():
        articulo = Articulo(nombre=form.nombre.data, fecha_compra=form.fecha_compra.data, fecha_caducidad=form.fecha_caducidad.data, usuarioArticulo=current_user)
        db.session.add(articulo)
        db.session.commit()
        flash('Elemento creado!', 'success')
        return redirect(url_for('home'))
    return render_template('create_articulo.html', title='New articulo',
                           form=form, legend='New articulo')


@app.route("/articulo/<int:articulo_id>")
def articulo(articulo_id):
    articulo = articulo.query.get_or_404(articulo_id)
    return render_template('articulo.html', title=articulo.title, articulo=articulo)


@app.route("/articulo/<int:articulo_id>/update", methods=['GET', 'POST'])
@login_required
def update_articulo(articulo_id):
    articulo = articulo.query.get_or_404(articulo_id)
    if articulo.author != current_user:
        abort(403)
    form = articuloForm()
    if form.validate_on_submit():
        articulo.title = form.title.data
        articulo.content = form.content.data
        db.session.commit()
        flash('Tu articulo ha sido actualizado!', 'success')
        return redirect(url_for('articulo', articulo_id=articulo.id))
    elif request.method == 'GET':
        form.title.data = articulo.title
        form.content.data = articulo.content
    return render_template('create_articulo.html', title='Update articulo',
                           form=form, legend='Update articulo')


@app.route("/articulo/<int:articulo_id>/delete", methods=['POST'])
@login_required
def delete_articulo(articulo_id):
    articulo = articulo.query.get_or_404(articulo_id)
    if articulo.author != current_user:
        abort(403)
    db.session.delete(articulo)
    db.session.commit()
    flash('Tu articulo ha sido eliminado!', 'success')
    return redirect(url_for('home'))


@app.route("/user/<string:username>")
def user_articulos(username):
    page = request.args.get('page', 1, type=int)
    user = User.query.filter_by(username=username).first_or_404()
    articulos = Articulo.query.filter_by(user_id=user.id)\
        .order_by(Articulo.fecha_caducidad.asc()).paginate(page=page, per_page=5)
    return render_template('user_articulos.html', articulos=articulos, user=user)
