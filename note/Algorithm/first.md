##### 1. 辗转相除法求最大公约数

```go
// gcd(124, 12) = gcd(12, 4) = gcd(4, 0) = 4

func gcd(a, b int) int {
	if b == 0 {
		return a
	}
	return gcd(b, a%b)
}
```

##### 2. 