makeShifts x n = let (f,s) = (splitAt n x)
    in if n < (length x)
    then (s ++ f) : (makeShifts x (n+1))
    else x : []

main = do
    _ <- getLine
    ws <- getContents
    mapM_ (\x -> putStrLn $ concatMap (\y -> y ++ " ") (makeShifts x 1)) (words ws)
