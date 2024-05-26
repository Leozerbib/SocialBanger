import requests
from django.http import HttpResponse
from django.shortcuts import render
from django.db.models import Count
from .utils import *
from .seo_functions import calculate_common_interests, calculate_common_friends


def user_list(request):
    users_data = get_all_users_from_api()
    users = users_data.get('data', [])
    status = users_data.get('status', 'error')
    message = users_data.get('message', '')

    return render(request, 'spring-api-communication.html', {'users': users, 'status': status, 'message': message})

def user_detail(request, user_id):
    user_data = get_one_users_from_api(user_id)
    user = user_data.get('data', [])
    status = user_data.get('status', 'error')
    message = user_data.get('message', '')
    return render(request, 'spring-api-detail.html', {'user': user, 'status': status, 'message': message})


def interest_list(request):
    interests_data = get_all_interests_from_api()
    interests = interests_data.get('data', [])
    status = interests_data.get('status', 'error')
    message = interests_data.get('message', '')

    return render(request, 'spring-api-communication.html', {'interests': interests, 'status': status, 'message': message})


def interest_detail(request, interest_id):
    interest_data = get_one_interest_from_api(interest_id)
    interest = interest_data.get('data', [])
    status = interest_data.get('status', 'error')
    message = interest_data.get('message', '')
    return render(request, 'spring-api-detail.html', {'interest': interest, 'status': status, 'message': message})


def subscriber_detail(request, user_id):
    subscriber_data = get_subscriber_from_api(user_id)
    subscriber = subscriber_data.get('data', [])
    status = subscriber_data.get('status', 'error')
    message = subscriber_data.get('message', '')
    return render(request, 'spring-api-detail.html', {'subscriber': subscriber, 'status': status, 'message': message})

def subscribed_detail(request, user_id):
    subscribed_data = get_subscribed_from_api(user_id)
    subscribed = subscribed_data.get('data', [])
    status = subscribed_data.get('status', 'error')
    message = subscribed_data.get('message', '')
    return render(request, 'spring-api-detail.html', {'subscribed': subscribed, 'status': status, 'message': message})



# Define user with similar interest (for recommendation)
def get_user_suggestion_on_interests(request, user_id):
    users_suggestion = calculate_common_interests(user_id)
    return HttpResponse('')

def get_user_suggestion_on_subscriptions(request, user_id):
    users_suggestion = calculate_common_friends(user_id)
    return HttpResponse('')



# # Define friend of friend (for recommendation)
# def calculate_common_friends(user_id):
#     user = User.objects.get(id=user_id)
#     friends = user.subscriptions.all()
#     common_friends = Subscription.objects.filter(user_id__in=[f.subscribed_user_id for f in friends]).annotate(num_common=Count('user_id')).order_by('-num_common')
#     return common_friends
