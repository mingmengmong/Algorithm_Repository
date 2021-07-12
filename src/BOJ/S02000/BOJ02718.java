package BOJ.S02000;

import java.util.Scanner;

public class BOJ02718 {
    int testcase;
    int N;
    int[] arr;

    public void start(){
        Scanner sc = new Scanner(System.in);

        testcase = sc.nextInt();
        for(int t=0; t<testcase; ++t){
            N = sc.nextInt();
            arr = new int[N+1];
            arr[0] = 1;
            arr[1] = 1;

            for(int i=2; i<=N; ++i) {
                arr[i] = arr[i - 1] + arr[i - 2] * 4;
                for(int k = i-3; k>=0; --k)
                    arr[i] += arr[k]*(3-(i-k)%2);
            }

            System.out.println(arr[N]);
        }



        sc.close();
    }
}
/*
1   2
|   ||  ||  --  --  --
|   ||  ||  ||  --  --
|   ||  --  ||  ||  --
|   ||  --  --  ||  --
3
||| |-- |-- |--
||| ||| |-- |--
|-- ||| ||| |--
|-- |-- ||| |--

||| ||| --| --| --|
||| ||| ||| --| --|
||| --| ||| ||| --|
||| --| --| ||| --|

|-- --|
|-- --|
--| |--
--| |--

|----
|----
----|
----|

|--|
|--|
----
----

----
----
|--|
|--|

----
|--|
|--|
----

--------
|------|
|------|
--------

\----\
\----\
------

 */

