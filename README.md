Wisnu Pramadhitya Ramadhan
1606918055

# WRITE UP
1. Apa fungsi BCryptPasswordEncoder?
> Password pengguna tidak boleh disimpan dalam bentuk plain text untuk menjaga kerahasiaan maka kita hash password pengguna.
Kegunaan dari BCryptPasswordEncoder adalah sebagai encoder untuk melakukan hashing dengan fungsi hash BCrypt.
Class tersebut memiliki fungsi encode dan matches.
2. Apa yang dilakukan baris berikut? (Method pada kelas UserDetailsServiceImpl.java)
```
Set<GrantedAuthority> grantedAuthoritySet = new HashSet<>();
grantedAuthoritySet.add(new SimpleGrantedAuthority(user.getRole()));
```
> Kita membuat set yang berisi otoritas yang user miliki. Dalam hal ini kita membagi otoritas berdasarkan rolenya.
Class SimpleGrantedAuthority menyimpan string representasi dari otoritas yang dimiliki user yang terautentikasi dan akan
dicek ketika terdapat request dari user tersebut.