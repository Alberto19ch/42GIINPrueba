from flask_wtf import FlaskForm
from datetime import datetime, date, timedelta
from flask_wtf.file import FileField, FileAllowed
from flask_login import current_user
from wtforms import StringField, PasswordField, SubmitField, BooleanField, TextAreaField, DateField
from wtforms.validators import DataRequired, Length, Email, EqualTo, ValidationError
from app.models import User


class RegistrationForm(FlaskForm):
    username = StringField('Nombre usuario',
                           validators=[DataRequired(), Length(min=2, max=20)])
    email = StringField('Email',
                            validators=[DataRequired(), Email()])
    nombre = StringField('Nombre',
                            validators=[DataRequired(), Length(min=2, max=20)])
    apellido = StringField('Apellido',
                           validators=[DataRequired(), Length(min=2, max=20)])
    password = PasswordField('Contraseña', validators=[DataRequired()])
    confirm_password = PasswordField('Confirmar contraseña',
                                     validators=[DataRequired(), EqualTo('password')])
    submit = SubmitField('Sign Up')

    def validate_username(self, username):
        user = User.query.filter_by(username=username.data).first()
        if user:
            raise ValidationError('Nombre de usuario en uso. Por favor seleccione uno distinto.')

    def validate_email(self, email):
        user = User.query.filter_by(email=email.data).first()
        if user:
            raise ValidationError('Email en uso. Por favor seleccione uno distinto.')


class LoginForm(FlaskForm):
    email = StringField('Email',
                        validators=[DataRequired(), Email()])
    password = PasswordField('Contraseña', validators=[DataRequired()])
    remember = BooleanField('Recuerdame')
    submit = SubmitField('Login')


class UpdateAccountForm(FlaskForm):
    username = StringField('Nombre de usuario',
                           validators=[DataRequired(), Length(min=2, max=20)])
    email = StringField('Email',
                        validators=[DataRequired(), Email()])
    nombre = StringField('Nombre',
                            validators=[DataRequired(), Length(min=2, max=20)])
    apellido = StringField('Apellido',
                           validators=[DataRequired(), Length(min=2, max=20)])
    submit = SubmitField('Update')

    def validate_username(self, username):
        if username.data != current_user.username:
            user = User.query.filter_by(username=username.data).first()
            if user:
                raise ValidationError('Nombre de usuario en uso. Por favor seleccione uno distinto.')

    def validate_email(self, email):
        if email.data != current_user.email:
            user = User.query.filter_by(email=email.data).first()
            if user:
                raise ValidationError('Email en uso. Por favor seleccione uno distinto..')


class articuloForm(FlaskForm):
    nombre = StringField('Nombre', validators=[DataRequired()])
    fecha_compra = DateField('Fecha de Compra', format='%Y-%m-%d',default=date.today() ,validators=[DataRequired()])
    fecha_caducidad = DateField('Fecha de Caducidad', format='%Y-%m-%d',validators=[DataRequired()])
    submit = SubmitField('articulo')
