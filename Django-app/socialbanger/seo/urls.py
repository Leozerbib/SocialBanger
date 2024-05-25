from django.urls import path
from . import views

""" URL List to access Django views """
urlpatterns = [
    # USERS
    path('users/', views.user_list, name='user_list'),
    path('users/<int:user_id>/', views.user_detail, name='user_detail'),

    # INTERESTS
    path('interests/', views.interest_list, name='interest_list'),
]
