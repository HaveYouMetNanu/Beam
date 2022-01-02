import requests
import random
import sys
import math

def generate_random_data(num_rows):
    for _ in range(num_rows):
        flt1 = float(random.randint(0,100))
        flt2 = float(random.randint(0,100))
        dec_lat = random.random()/100
        dec_lon = random.random()/100
        post_req = "http://localhost:8080/location?lat={}&lon={}".format(flt1+dec_lon, flt2+dec_lat)
        response = requests.post(post_req)
        print(response)

generate_random_data(100)


