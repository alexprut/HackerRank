class Pair implements Comparable<Pair>{
      BigDecimal number;
      String numberString;

      Pair(BigDecimal number, String numberString) {
        this.number = number;
        this.numberString = numberString;
      }

      public int compareTo(Pair b) {
        if (number.compareTo(b.number) < 0) {
          return -1;
        }

        return 1;
      }
    }


    ArrayList<Pair> big = new ArrayList<Pair>();

    for (int i = 0; i < s.length - 2; i++) {
      big.add(
          new Pair(new BigDecimal(s[i]), s[i])
      );
    }

    Collections.sort(big, Collections.reverseOrder());

    for (int i = 0; i < s.length - 2; i++) {
      s[i] = big.get(i).numberString;
    }
