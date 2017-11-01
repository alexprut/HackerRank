#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

string timeToString(int n) {
    string hour;

    switch (n) {
        case 0:
            hour = "zero";
        case 1:
            hour = "one";
            break;
        case 2:
            hour = "two";
            break;
        case 3:
            hour = "three";
            break;
        case 4:
            hour = "four";
            break;
        case 5:
            hour = "five";
            break;
        case 6:
            hour = "six";
            break;
        case 7:
            hour = "seven";
            break;
        case 8:
            hour = "eight";
            break;
        case 9:
            hour = "nine";
            break;
        case 10:
            hour = "ten";
            break;
        case 11:
            hour = "eleven";
            break;
        case 12:
            hour = "twelve";
            break;
        case 13:
            hour = "thirteen";
            break;
        case 14:
            hour = "fourteen";
            break;
        case 15:
            hour = "fifteen";
            break;
        case 16:
            hour = "sixteen";
            break;
        case 17:
            hour = "seventeen";
            break;
        case 18:
            hour = "eighteen";
            break;
        case 19:
            hour = "nineteen";
            break;
        case 20:
            hour = "twenty";
            break;
        case 30:
            hour = "thirty";
            break;
        case 40:
            hour = "forty";
            break;
        case 50:
            hour = "fifty";
            break;
        default:
            hour = "undefined";
            break;
    }

    return hour;
}

int main() {
    string result;
    int hour;
    cin >> hour;
    int minute;
    cin >> minute;

    if (minute == 0) {
        result = timeToString(hour) + " o' clock";
    } else if (minute == 1) {
        result = "one minute past " + timeToString(hour);
    } else if (minute == 59) {
        result = "one minute to " + timeToString(hour);
    } else if (minute == 15) {
        result = "quarter past " + timeToString(hour);
    } else if (minute == 45) {
        result = "quarter to " + timeToString(hour+1);
    } else if (minute == 30) {
        result = "half past " + timeToString(hour);
    } else if (minute > 0 && minute < 30) {
        if (timeToString(minute) == "undefined") {
            result = timeToString((minute/10)*10) + " " +
                    timeToString(minute % 10) + " minutes past " + timeToString(hour);
        } else {
            result = timeToString(minute) + " minutes past " + timeToString(hour);
        }
    } else if (minute > 30 ) {
        if (timeToString(60 - minute) == "undefined") {
            result = timeToString(((60 - minute) / 10) * 10) + " " +
                     timeToString((60 - minute) % 10) + " minutes to " + timeToString(hour+1);
        } else {
            result = timeToString(60 - minute) + " minutes to " + timeToString(hour+1);
        }
    }

    cout << result;

    return 0;
}
