import random
import datetime
from faker import Faker # type: ignore
import psycopg2

# Initialize Faker
fake = Faker()

# Database connection
conn = psycopg2.connect(
    dbname="socialbanger",
    user="socialbanger_user",
    password="UT2KngvtDRo9BU4R371Q6vIeQdFaozp9",
    host="dpg-cp1nrk8l5elc73f1mdng-a.frankfurt-postgres.render.com",
    port="5432",

)
cur = conn.cursor()

# Constants
NUM_USERS = 50
NUM_POSTS = 50
NUM_COMMENTS = 300
NUM_LIKES = 40
NUM_HASHTAGS = 100
NUM_SUBSCRIPTIONS = 150

# Generate fake data for countries
def generate_countries():
    countries = []
    
    cur.execute("SELECT * FROM countries")
    rows = cur.fetchall()
    
    for row in rows:
        country = {
            'id': row[0],
            'code': row[1],
            'country': row[2],
            'flag_image_url': row[3]
        }
        countries.append(country)
    
    return countries

def generate_interest():
    interests = []
    
    cur.execute("SELECT * FROM interests")
    rows = cur.fetchall()
    
    for row in rows:
        interest = {
            'id': row[0],
            'category': row[1],
            'subcategory': row[2]
        }
        interests.append(interest)
    
    return interests

# Generate fake data for users
def generate_users(num_users, country,interest):
    users = []
    print(country[0].get('id'))
    for _ in range(num_users):
        users.append({
            'id': _ + 1,
            'first_name': fake.first_name(),
            'last_name': fake.last_name(),
            'email': fake.unique.email(),
            'password': fake.password(),
            'created_at': fake.date_time_this_decade(),
            'updated_at': fake.date_time_this_decade(),
            'age': random.randint(18, 90),
            'country_id': country[random.randint(1, len(country)-1)].get('id'),
            'count_subscribers': random.randint(0, 1000),
            'count_subscriptions': random.randint(0, 1000),
            'username': fake.unique.user_name(),
            'gender': random.choice(['Male', 'Female', 'other']),
            'user_status': random.choice(['Connected', 'notConnected'])
        })
    return users

# Generate fake data for user interests
def generate_user_interests(num_users, interests):
    userInterests = []
    for i in range(num_users):
        interestsCopy = interests.copy()
        inter = []
        ra = random.randint(1, 5)
        for _ in range(ra):
            interest = random.choice(interestsCopy)
            inter.append(interest.get('id'))
            interestsCopy.remove(interest)
        userInterests.append({
            'user_id': i+1,
            'interest_id': inter
        })
    return userInterests
# Generate fake data for posts
def generate_posts(num_posts, num_users,country):
    posts = []
    for _ in range(num_posts):
        posts.append({
            'id': _ + 1,
            'user_id': random.randint(1, num_users),
            'content': fake.text(),
            'created_at': fake.date_time_this_decade(),
            'updated_at': fake.date_time_this_decade(),
            'location': random.choice(country).get('code'),
            'img_url': 'https://img-0.journaldunet.com/qicgNkKdB3YibZC8x8g6iA4Z3B4=/540x/smart/ab68ae85e74c4b2691006c0467f8b7dc/ccmcms-jdn/25881466.jpg'
        })
    return posts

def generate_postsint(posts, interests):
    posts_interest = []
    for _ in range(len(posts)):
        for i in range(random.randint(1, 5)):
            posts_interest.append({
                'post_id': _ + 1,
                'interest_id': random.choice(interests).get('id')
})
    return posts_interest

# Generate fake data for comments
def generate_comments(num_comments, num_users, num_posts):
    comments = []
    for _ in range(num_comments):
        comments.append({
            'id': _ + 1,
            'user_id': random.randint(1, num_users),
            'post_id': random.randint(1, num_posts),
            'content': fake.sentence(),
            'created_at': fake.date_time_this_decade(),
            'updated_at': fake.date_time_this_decade()
        })
    return comments

# Generate fake data for likes
def generate_likes(num_likes, num_users, num_posts,users):
    likes = []
    oui = 0

    for _ in range(num_posts):
        userCopy = users.copy()
        for i in range(num_likes):
            if random.randint(0, 10) < random.randint(0, 10):
                oui += 1
                print(oui)
                user = random.choice(userCopy)
                userCopy.remove(user)
                likes.append({
                    'id': oui,
                    'user_id': user.get('id'),
                    'post_id': i + 1,
                    'created_at': fake.date_time_this_decade()
                })
    print(oui)
    return likes

# Generate fake data for hashtags
def generate_hashtags(num_hashtags):
    hashtags = []
    for _ in range(num_hashtags):
        hashtags.append({
            'id': _ + 1,
            'name': fake.unique.word()
        })
    return hashtags

# Generate fake data for subscriptions
def generate_subscriptions(num_subscriptions, users):
    subscriptions = []
    i = 0
    for _ in range(len(users)):
        for user in users:
            if user.get('id') != _ + 1:
                i += 1
                subscriptions.append({
                    'id': i,
                    'user_id': _ + 1,
                    'subscribed_user_id': user.get('id'),
                    'created_at': fake.date_time_this_decade()
                })
    return subscriptions

# Insert data into the database
def insert_data():
    countries = generate_countries()
    interests = generate_interest()
    users = generate_users(NUM_USERS, countries,interests)
    userInterests = generate_user_interests(NUM_USERS, interests)
    posts = generate_posts(NUM_POSTS, NUM_USERS,countries)
    posts_interest = generate_postsint(posts, interests)
    comments = generate_comments(NUM_COMMENTS, NUM_USERS, NUM_POSTS)
    likes = generate_likes(NUM_LIKES, NUM_USERS, NUM_POSTS,users)
    hashtags = generate_hashtags(NUM_HASHTAGS)
    subscriptions = generate_subscriptions(NUM_SUBSCRIPTIONS, users)

    for subscription in subscriptions:
        printLog(subscription['id'],"subscriptions",False,False)
        cur.execute("""
            INSERT INTO public.subscriptions (id, user_id, subscribed_user_id, created_at)
            VALUES (%s, %s, %s, %s)
            """, (subscription['id'], subscription['user_id'], subscription['subscribed_user_id'], subscription['created_at']))

    printLog(0,"subscriptions",False,True)

    print('Data inserted successfully!')

def printLog(step,tableName,started,ended):
    if started:
        print(f"Started {step} {tableName} at {datetime.datetime.now()}")
        return
    if ended:
        print(f"Ended {step} {tableName} at {datetime.datetime.now()}")
        return
    if step%10 == 0:
        for i in range(100):
            print()
        print(f"=====Inserted {step} {tableName} at {datetime.datetime.now()}")
        for i in range(int(step/10)):
            print("=", end="", flush=True),
        print()
        return


    
    
    conn.commit()

# Run the script
if __name__ == "__main__":
    try:
        insert_data()
        pass
    except psycopg2.Error as e:
        print(e)
        print(e.sql)
    cur.close()
    conn.close()
