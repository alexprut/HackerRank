-- Enter your code here. Read input from STDIN. Print output to STDOUT

f [] = []
f (x:xs) = (abs x) : (f xs)

-- This section handles the Input/Output and can be used as it is. Do not modify it.
main = do
   inputdata <- getContents
   mapM_ putStrLn $ map show $ f $ map (read :: String -> Int) $ lines inputdata
