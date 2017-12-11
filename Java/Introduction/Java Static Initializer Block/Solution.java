public static Scanner sc = new Scanner(System.in);
public static int B = initB();
public static int H = initH();
public static boolean flag = initFlag();

public static int initB() {
    B = sc.nextInt();
    return B;
}

public static int initH() {
    H = sc.nextInt();
    return H;
}

public static boolean initFlag() {
    if (H <= 0 || B <=0) {
        System.out.println("java.lang.Exception: Breadth and height must be positive");
        return false;
    }

    return true;
}
