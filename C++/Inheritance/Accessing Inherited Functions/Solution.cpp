class D : A, B, C
{

	int val;
	public:
		//Initially val is 1
		 D()
		 {
		 	val = 1;
		 }


		 //Implement this function
		 void update_val(int new_val)
		 {
            int tmp = new_val;
            while (0 <= tmp / 2 && tmp%2 == 0) {
                A::func(val);
                tmp = tmp / 2;
            }

            while (0 <= tmp / 3 && tmp% 3 == 0) {
                B::func(val);
                tmp = tmp / 3;
            }

            while (0 <= tmp / 5 && tmp% 5 == 0) {
                C::func(val);
                tmp = tmp / 5;
            }
		 }
		 //For Checking Purpose
		 void check(int); //Do not delete this line.
};
