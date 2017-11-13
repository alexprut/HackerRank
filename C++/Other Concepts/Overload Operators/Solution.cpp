//Overload operators + and << for the class complex
//+ should add two complex numbers as (a+ib) + (c+id) = (a+c) + i(b+d)
Complex operator +(Complex f, Complex s) {
    Complex z;
    z.a = f.a + s.a;
    z.b = f.b + s.b;

    return z;
}

//<< should print a complex number in the format "a+ib"
ostream& operator <<(ostream& os, Complex &z) {
    cout << "" << z.a << "+" << "i" << z.b;
    return os;
}
