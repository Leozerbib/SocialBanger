from collections import Counter

from django.shortcuts import render
from django.db.models import Count
from .utils import *

def calculate_common_interests(user_id):
    # Get User Interests
    user_interests = get_one_users_from_api(user_id)

    # Initializing counting list
    user_common_interests = Counter()

    # For each interest we check which users share the same interest
    for interest in user_interests['data']['interests']:
        interest_id = interest['id']
        similar_users = get_one_interest_from_api(interest_id)

        # Add to the list the id of the user and increase the interests in common counter
        if similar_users['data']:
            for similar_user in similar_users['data']:
                users = similar_user['users']
                for user in users:
                    if user['id'] != user_id:  # Avoid the user itself
                        user_common_interests[user['id']] += 1

    # Convert into dict
    similar_users_sorted = [
        {'user_id': user_id, 'common_interests': count}
        for user_id, count in user_common_interests.most_common()
    ]

    return similar_users_sorted


def calculate_common_friends(user_id):
    # Get all Friend of the User
    user_subscribed = get_subscriber_from_api(user_id)

    # Initialize counting list
    user_common_friends = Counter()

    # Iterate over each user that the given user is subscribed to
    if user_subscribed['data']:
        for subscription in user_subscribed['data']:
            subscribed_user_id = subscription['user']['id']

            # Get the list of users that are subscribed to the current subscribed user
            similar_users = get_subscribed_from_api(subscribed_user_id)

            # Add to the counter the id of the users and increase the common friends counter
            if similar_users['data']:
                for similar_user in similar_users['data']:
                    friend_id = similar_user['subscribedUser']['id']
                    if friend_id != user_id:  # Avoid the user itself
                        user_common_friends[friend_id] += 1

    # Convert into dict
    similar_users_sorted = [
        {'user_id': user_id, 'common_friends': count}
        for user_id, count in user_common_friends.most_common()
    ]

    return similar_users_sorted


