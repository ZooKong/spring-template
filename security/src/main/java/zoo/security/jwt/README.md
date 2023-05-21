HMAC (Hash based Message Authentication Code = Hash(Message, Key) + Message

즉 HMAC는 원본 메시지가 변하면 그 해시값도 변하는 해싱(Hashing)의 특징을 활용하며 메시지의 변조 여부를 확인하여 무결성 및 기밀성을 제공하는 기술이다.

한마디로 표현하자면 대칭키를 이용한 알고리즘이다. (A symmetric algorithm)
2개 이상의 영역에서 키 값이 공유된다. (예를 들자면 Frontend와 Backend 또는 서로 다른 도메인의 API)

중요한 부분은 하나의 키를 이용하여 서명을 하므로 키 값이 손상되지 않도록 주의해야 한다.
: 키 값을 하드코딩으로 코드에 넣기 보다는 Spring으로 따지면  application.yml과 같은 문서 파일에 보관 하는 것을 권장한다.

 JOSE 헤더(JSON Object Signing and Encryption), JWT Claim Set, Signature라고 부른다.
 
***

> 참고

```
// jwt에 대한 간단한 소개 및 검증 사이트
https://jwt.io/introduction

// 공식 문서
https://www.rfc-editor.org/rfc/rfc7519

// jwt 관련 설명 블로그
https://jake-seo-dev.tistory.com/77
```

추가적으로 여기까지해ㅑ서 pnt에서 사용하고 다른 알고리즘에 대한 추가는 절차적으로 조금더 진행하자./.
 일단 security 먼저해야함 ..
테스트 코드도 필요함..
DecodedClaims에 문자열 있음 이거 클레임 클래스로 관리
HmacJsonWebToken verify에 대해 exception 시그니처에 표현하는 것이 좋을 것 같음..
