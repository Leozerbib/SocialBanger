from django.shortcuts import render
from django.db.models import Count

# Define user with similar interest (for recommendation)
def calculate_common_interests(user_id):
    user_interests = UserInterests.objects.filter(user_id=user_id)
    similar_users = UserInterests.objects.filter(interest_id__in=[ui.interest_id for ui in user_interests]).exclude(user_id=user_id).values('user_id').annotate(common_interests=Count('user_id')).order_by('-common_interests')
    return similar_users



# Define friend of friend (for recommendation)
def calculate_common_friends(user_id):
    user = User.objects.get(id=user_id)
    friends = user.subscriptions.all()
    common_friends = Subscription.objects.filter(user_id__in=[f.subscribed_user_id for f in friends]).annotate(num_common=Count('user_id')).order_by('-num_common')
    return common_friends
