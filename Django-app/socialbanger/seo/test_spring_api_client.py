import os
import unittest
import requests_mock
from django.conf import settings
from django.core.exceptions import ImproperlyConfigured

# Configure Django settings for the test
os.environ['DJANGO_SETTINGS_MODULE'] = 'socialbanger.settings'

# Initialize Django
import django
django.setup()

from .spring_api import SpringAPIClient

class TestSpringAPIClient(unittest.TestCase):

    def setUp(self):
        # Configuration de l'URL de base de l'API Spring
        self.client = SpringAPIClient()
        settings.SPRING_API_BASE_URL = "http://localhost:8090/api/v1"

    @requests_mock.Mocker()
    def test_get_user(self, mock):
        user_id = 1
        mock_url = f"{settings.SPRING_API_BASE_URL}/user/getById"
        mock_response = {'id': user_id, 'first_name': 'Daniel'}

        mock.get(mock_url, json=mock_response)

        response = self.client.get_user(user_id)
        self.assertEqual(response, mock_response)

    @requests_mock.Mocker()
    def test_get_all_users(self, mock):
        mock_url = f"{settings.SPRING_API_BASE_URL}/user/getAll"
        mock_response = [{'id': 1, 'first_name': 'Daniel'}, {'id': 2, 'first_name': 'Tara'}]

        mock.get(mock_url, json=mock_response)

        response = self.client.get_all_users()
        self.assertEqual(response, mock_response)

    @requests_mock.Mocker()
    def test_get_all_interests(self, mock):
        mock_url = f"{settings.SPRING_API_BASE_URL}/interest/getAll"
        mock_response = [{'id': 3, 'subcategory': 'Arts'}, {'id': 40, 'subcategory': 'Artificial Intelligence and Machine Learning'}]

        mock.get(mock_url, json=mock_response)

        response = self.client.get_all_interests()
        self.assertEqual(response, mock_response)

    @requests_mock.Mocker()
    def test_get_interest(self, mock):
        interest_id = 1
        mock_url = f"{settings.SPRING_API_BASE_URL}/interest/getById"
        mock_response = {'id': interest_id, 'subcategory': 'WebTech'}

        mock.get(mock_url, json=mock_response)

        response = self.client.get_interest(interest_id)
        self.assertEqual(response, mock_response)

if __name__ == '__main__':
    unittest.main()
