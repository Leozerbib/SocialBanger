import requests
from django.shortcuts import render
from django.db.models import Count
from .utils import *

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



# Define user with similar interest (for recommendation)
def calculate_common_interests(user_id):
    user_interests = UserInterests.objects.filter(user_id=user_id)
    similar_users = UserInterests.objects.filter(interest_id__in=[ui.interest_id for ui in user_interests]).exclude(user_id=user_id).values('user_id').annotate(common_interests=Count('user_id')).order_by('-common_interests')
    return similar_users



# # Define friend of friend (for recommendation)
# def calculate_common_friends(user_id):
#     user = User.objects.get(id=user_id)
#     friends = user.subscriptions.all()
#     common_friends = Subscription.objects.filter(user_id__in=[f.subscribed_user_id for f in friends]).annotate(num_common=Count('user_id')).order_by('-num_common')
#     return common_friends
