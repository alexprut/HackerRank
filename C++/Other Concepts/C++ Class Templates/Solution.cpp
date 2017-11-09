template <class T>
class AddElements {
    public:
    T element;
    AddElements (T arg) {element=arg;}
    T add(T el2) {
        return element + el2;
    }
};

template <>
class AddElements <string> {
    public:
    string element;
    AddElements (string arg) {element=arg;}
    string concatenate (string el2) {
        return element + el2;
    }
};
