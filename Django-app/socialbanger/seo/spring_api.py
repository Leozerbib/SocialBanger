import requests
from django.conf import settings


"""Class that manage the function to communicate with Spring server through API"""
class SpringAPIClient:
    def __init__(self):
        self.base_url = settings.SPRING_API_BASE_URL    # Get the base API url access to Spring

    ################ USER ################

    def get_user(self, user_id):
        url = f"{self.base_url}/user/getById"    # URL redirect to Spring Controller
        response = requests.get(url, params={'id': user_id})     # Use of post method with json file
        response.raise_for_status()     # Raise an error for bad status codes
        return response.json()

    def get_all_users(self):
        url = f"{self.base_url}/user/getAll"
        response = requests.get(url)
        response.raise_for_status()
        return response.json()


    ################ INTERSEST ################

    def get_all_interests(self):
        url = f"{self.base_url}/interest/getAll"
        response = requests.get(url)
        response.raise_for_status()
        return response.json()

    def get_interest(self, interest_id):
        url = f"{self.base_url}/interest/getById"
        response = requests.get(url, params={'id': interest_id})
        response.raise_for_status()
        return response.json()


    ################ SUBSCRIPTION ################

    def get_subscriber(self, subscribed_id):
        url = f"{self.base_url}/user/Subscriber"
        response = requests.get(url, params={'id': subscribed_id})
        response.raise_for_status()
        return response.json()


    def get_subscribed(self, subscriber_id):
        url = f"{self.base_url}/user/Sub"
        response = requests.get(url, params={'id': subscriber_id})
        response.raise_for_status()
        return response.json()

    ################ ADD MORE FUNCTIONS HERE ################

    # TODO: 1- DEFINE ALL ACCESSOR IN CONTROLLERS


