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
        print("interest_id", interest_id)
        similar_users = get_one_interest_from_api(interest_id)
        print("similar_users", similar_users['data'])

        # Add to the list the id of the user and increase the interests in common counter
        if similar_users['data']:
            for similar_user in similar_users['data']:
                if similar_user['id'] != user_id:  # Avoid the user itself
                    user_common_interests[similar_user['id']] += 1

    # Convert into dict
    similar_users_sorted = [
        {'user_id': user_id, 'common_interests': count}
        for user_id, count in user_common_interests.most_common()
    ]

    return similar_users_sorted



 