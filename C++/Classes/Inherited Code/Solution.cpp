class BadLengthException: public std::exception {
    private:
    int length;
    public:
    BadLengthException(int n) {
        length = n;
    }

    virtual string what() {
      return to_string(length);
    }
};
