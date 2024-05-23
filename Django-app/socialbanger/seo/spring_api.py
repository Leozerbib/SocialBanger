import requests
from django.conf import settings

class SpringAPIClient:
    def __init__(self):
        self.base_url = settings.SPRING_API_BASE_URL

    def get_user(self, user_id):
        url = f"{self.base_url}/users/{user_id}"
        response = requests.get(url)
        response.raise_for_status()  # Raise an error for bad status codes
        return response.json()

    def get_all_users(self):
        url = f"{self.base_url}/users"
        response = requests.get(url)
        response.raise_for_status()
        return response.json()

    # Add more methods for other endpoints as needed
