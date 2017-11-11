fib :: Int -> Int
fib n =
  let fib = 0:1:zipWith (\x y -> mod (x + y) (10^8 + 7)) fib (tail fib)
  in fib!!n

main = do
    _ <- getLine
    inputData <- getContents
    mapM_ (\x -> print x) $ map fib $ map (read :: String -> Int) $ lines inputData
