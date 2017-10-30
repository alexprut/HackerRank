class Person {
 public:
  string name;
  int age;
  virtual void getdata() {}
  virtual void putdata() {}
};

class Professor: public Person {
 public:
  Professor () {
    id++;
    cur_id = id;
  }
  int publications;
  int cur_id;
  static int id;
  virtual void getdata() {
    cin >> name >> age >> publications;
  }
  virtual void putdata() {
    cout << name << " " << age << " " << publications << " " << cur_id << "\n";
  }
};
int Professor::id = 0;

class Student: public Person {
 public:
  Student () {
    id++;
    cur_id = id;
  }
  int cur_id;
  static int id;
  int marks[6];
  virtual void getdata() {
    cin >> name >> age;
    for (int i = 0; i < 6; ++i) {
      cin >> marks[i];
    }
  }
  virtual void putdata() {
    int sum = 0;
    for (int i = 0; i < 6; ++i) {
      sum += marks[i];
    }

    cout << name << " " << age << " " << sum << " " << cur_id << "\n";
  }
};
int Student::id = 0;
