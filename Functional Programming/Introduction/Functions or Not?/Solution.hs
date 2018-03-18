import qualified Data.Map as Map

main :: IO ()
main = do
  n <- getLine
  mapM_ (\_ -> do
    e <- getLine
    entries <- sequence $ map (\_ -> do
        x <- getLine
        let (y:z:[]) = words x
        return (read y :: Int, read z :: Int)
        ) [1..(read e :: Int)]
    if Map.size (Map.fromList entries) == length entries
      then putStrLn "YES"
      else putStrLn "NO"
    return ()
    ) [1..(read n :: Int)]
