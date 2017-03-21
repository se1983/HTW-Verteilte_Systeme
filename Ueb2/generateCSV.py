import csv
from random import randint
with open('temps.csv', 'w', newline='') as csvfile:
    spamwriter = csv.writer(csvfile, delimiter=',',
                            quotechar=',', quoting=csv.QUOTE_MINIMAL)
    
    spamwriter.writerow(["day", "hour", "temp"])
    numdays = 10000
    base = datetime.datetime.today()
    for day in [base - datetime.timedelta(days=x) for x in range(0, numdays)]:
        for hour in range(25):
            spamwriter.writerow([day.date(), str(hour) + ":00", str(randint(-10, 35))] )