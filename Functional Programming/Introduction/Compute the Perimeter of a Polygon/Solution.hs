d [x,y,x1,y1] = sqrt $ (x1 - x)^2 + (y1 - y)^2
d _ = 0

p [] acc = acc
p points acc = p (drop 2 points) (acc + (d (take 4 points)))

perimeter points = p (points ++ (take 2 points)) 0

main :: IO ()
main = do
    _ <- getLine
    x <- getContents
    let f = map read $ words x
    print $ perimeter f
