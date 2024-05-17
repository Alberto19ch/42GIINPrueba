from datetime import datetime
from app import db, login_manager
from flask_login import UserMixin
from enum import Enum

@login_manager.user_loader
def load_user(user_id):
    return User.query.get(int(user_id))


class User(db.Model, UserMixin):
    id = db.Column(db.Integer, primary_key=True)
    username = db.Column(db.String(20), unique=True, nullable=False)
    email = db.Column(db.String(120), unique=True, nullable=False)
    nombre = db.Column(db.String(20), nullable=False)
    apellido = db.Column(db.String(20), nullable=False)
    password = db.Column(db.String(60), nullable=False)
    articulos = db.relationship('Articulo', backref='usuarioArticulo', lazy=True)

    def __repr__(self):
        return f"User('{self.username}', '{self.email}', '{self.nombre}', '{self.apellido}')"


class Category(Enum):
    FRUTA = 1
    VERDURA = 2
    POLLO = 3
    CARNE_ROJA = 4
    CARNE_BLANCA = 5
    PESCADO = 6
    HUEVO = 7
    PAN = 8
    CEREAL = 9
    LEGUMGRE = 10
    LACTEO = 11
    PREPARADO = 12


class Articulo(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    nombre = db.Column(db.String(100), nullable=False)
    fecha_caducidad = db.Column(db.DateTime, nullable=False)
    fecha_compra = db.Column(db.DateTime, nullable=False, default=datetime.utcnow)
    fecha_consumo = db.Column(db.DateTime, nullable=True)
    user_id = db.Column(db.Integer, db.ForeignKey('user.id'), nullable=False)
    category = db.Column(db.Enum(Category))
    def __repr__(self):
        return f"Articulo('{self.title}', '{self.fecha_caducidad}')"
