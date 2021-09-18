import os
#导入 os 模块
with open(r'r'/home/yanghao/Desktop/ToEncrypt.txt', 'r') as f:
plaintext=f.read()
#读取明文文件
print(plaintext)
#输出明文文件的内容
key='cipher'
#设置密钥，此处可以改为 input（请输入密钥：）
ascii='abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ.'
#设置明文空间和密文空
间的字符
keylen=len(key)
#密钥长度，此处应该为 6
ptlen=len(plaintext)
#明文长度
ciphertext=''
#定义一个密文字符串
i=0
while i<ptlen:
j=i%keylen
k=ascii.index(key[j])
#检索出密钥字符对应的数字（mod 26 下)
try:
m=ascii.index(plaintext[i])
ciphertext+=ascii[(m+k)%26]
except:
print("error")
i+=1
print(ciphertext)
#输出密文
with open(r'/home/yanghao/Desktop/Encrypted.txt','w+',encoding='utf-8')as fp:
fp.write(ciphertext)
#将密文输出到文件 Encrypted.txt
fp.close()