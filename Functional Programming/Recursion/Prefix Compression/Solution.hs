f [] [] r = r
f [] y (r1, r2, _) = (r1, r2, y)
f x [] (r1, _, r3) = (r1, x, r3)
f (x:xs) (y:ys) (r1, r2, r3) = if x == y
    then f (xs) (ys) (r1 + 1, r2, r3)
    else (r1, x:xs, y:ys)

g 0 x = []
g c (x:xs) = x : (g (c-1) xs)

main = do
    x <- getLine
    y <- getLine
    let (r1, r2, r3) = f x y (0, "", "")
    putStrLn $ (show $ r1) ++ " " ++ (g r1 x)
    putStrLn $ (show $ length r2) ++ " " ++ r2
    putStrLn $ (show $ length r3) ++ " " ++ r3
