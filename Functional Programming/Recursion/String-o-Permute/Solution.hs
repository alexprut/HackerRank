permute (x:x1:xs) = x1 : x : (permute xs)
permute x = x

main = do
    _ <- getLine
    texts <- getContents
    let ws = words texts
    mapM_ (\x -> putStrLn (permute x)) ws
