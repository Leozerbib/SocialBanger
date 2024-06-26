from django.urls import path
from . import views

""" URL List to access Django views """
urlpatterns = [
    # USERS
    path('users/', views.user_list, name='user_list'),
    path('users/<int:user_id>/', views.user_detail, name='user_detail'),

    # INTERESTS
    path('interests/', views.interest_list, name='interest_list'),
    path('interests/<int:interest_id>/', views.interest_detail, name='interest_detail'),

    #SUBSCRIPTION
    path('subscribed/<int:user_id>/', views.subscribed_detail, name='subscribed_detail'),
    path('subscriber/<int:user_id>/', views.subscriber_detail, name='subscriber_detail'),

    # SEO
    path('seo/i/<int:user_id>/', views.get_user_suggestion_on_interests, name='get_user_suggestion_on_interests'),
    path('seo/f/<int:user_id>/', views.get_user_suggestion_on_subscriptions, name='get_user_suggestion_on_subscriptions'),
]
