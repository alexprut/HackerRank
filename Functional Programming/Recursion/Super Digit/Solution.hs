import Data.Char

superDigit [] = []
superDigit (x:[]) = x:[]
superDigit xs = superDigit(show (sumDigits xs))

sumDigits xs = foldl (\acc x -> acc + (digitToInt x)) 0 xs

problem n p = superDigit (show ((sumDigits n) * (read p)))

main = do
    ws <- getContents
    let xs = words ws
    putStrLn (problem (head xs) (last xs))
