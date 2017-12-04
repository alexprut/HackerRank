getCommonDivisors m n = length [i | i <- [1..(gcd m n)], (mod m i) == 0, (mod n i) == 0]

main = do
    input <- getContents
    let l = lines input
    mapM_ (
        \x -> do
            let mn = words x
            putStrLn $ show (getCommonDivisors (read (head mn) :: Int) (read (last mn) :: Int))) (tail l)
