import qualified Data.Vector as V (fromList, (!), Vector)

pentagonCounterList = V.fromList $ [pentagonCounter x | x <- [0..10^5]]

pentagonCounter 1 = 1
pentagonCounter 2 = 5
pentagonCounter n = n + 2 * (n-1) + (pentagonCounterList V.! (n - 1))

main = do
    _ <- getLine
    lines <- getContents
    let ws = words lines
    mapM_ (\x -> putStrLn (show (pentagonCounter $ read x))) ws