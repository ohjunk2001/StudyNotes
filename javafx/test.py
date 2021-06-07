import os                       

open(r'C:\Users\Administrator\ToEncrypt.txt', 'r') as f: 

plaintext=f.read()           
print(plaintext)                 
   
key='cipher'                   

ascii='abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ.' 

keylen=len(key)             
 
while i<ptlen:     j=i%keylen 
    k=ascii.index(key[j])        #检索出密钥字符对应的数字（mod 26 下)     try: 
        m=ascii.index(plaintext[i])         ciphertext+=ascii[(m+k)%26]     except:         print("error") 
    i+=1      print(ciphertext)           #输出密文 


 
with open(r'C:\Users\Administrator\Desktop\mima\Encrypted.txt','w+',encoding='utf-8')as fp: 
    fp.write(ciphertext)         #将密文输出到文件 Encrypted.txt fp.close() 