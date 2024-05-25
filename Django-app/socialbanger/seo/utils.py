import requests
from .spring_api import SpringAPIClient

def get_all_users_from_api():
    try:
        client = SpringAPIClient()
        response = client.get_all_users()
        return {'status': response['statusCode'], 'data': response['data']}
    except requests.exceptions.HTTPError as e:
        return {'status': 'error', 'message': str(e), 'data': None}


def get_one_users_from_api(user_id):
    try:
        client = SpringAPIClient()
        response = client.get_user(user_id)
        return {'status': response['statusCode'], 'data': response['data']}
    except requests.exceptions.HTTPError as e:
        return {'status': 'error', 'message': str(e), 'data': None}


def get_all_interests_from_api():
    try:
        client = SpringAPIClient()
        response = client.get_all_interests()
        return {'status': response['statusCode'], 'data': response['data']}
    except requests.exceptions.HTTPError as e:
        return {'status': 'error', 'message': str(e), 'data': None}

# TODO: 2- Add utils function that get data according to SpringAPIClient functions
