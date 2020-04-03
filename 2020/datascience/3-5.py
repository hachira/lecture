#   3-5 Json 파일 읽기
import json

with open("3-5.json") as f:
    frozen = json.load(f)

print(frozen)

#   dictionary
print("This movie title is "+frozen["title"])
print("actor list is ")
for actor in frozen["actor"]:
    print("actor is "+actor["name"]+". and gender is "+actor["gender"])

profile = { "name" : "changrak",
            "title" : "professor",
            "gender" : "male",
            "company" : [ "kbs", "gonusoft", "netmarble", "dragon lab" ]
            }

print(profile)

profile["age"] = 30
profile["birth"] = { "month" : 12, "day" : 5 }

#   json으로 파일 저장하기
with open("3-5w.json", mode="w") as f:
    json.dump(profile, f)


print("My birth day is %02d.%02d"%(profile["birth"]["month"], profile["birth"]["day"]))
