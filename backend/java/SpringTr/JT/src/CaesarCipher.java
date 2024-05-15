/**
 * 21401070207-软工2102-李长辉
 */
public class CaesarCipher {

    /**
     * 加密函数，根据给定的密钥将明文转换为密文。
     * 通过(char)转化为ASII码
     *
     * @param plaintext 明文字符串。
     * @param key       加密密钥，范围应该是0到25。
     * @return 返回加密后的密文字符串。
     */
    public static String encrypt(String plaintext, int key) {
        StringBuilder ciphertext = new StringBuilder();

        // 遍历明文中的每一个字符，判断字符是否需要加密。
        for (char ch : plaintext.toCharArray()) {
            // 检查字符是否为字母
            if (Character.isLetter(ch)) {
                // 确定字母的基准值('A' 或 'a')
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                // 根据加密公式计算密文字母并应用模运算保证结果仍在字母表范围内
                ch = (char)(((ch - base + key) % 26) + base);
            }
            // 将处理后的字符添加到密文字符串中
            ciphertext.append(ch);
        }
        // 返回最终的密文字符串
        return ciphertext.toString();
    }

    /**
     * 解密函数，根据给定的密钥将密文转换回明文。
     * 21401070207-软工2102-李长辉
     * @param ciphertext 密文字符串。
     * @param key        解密密钥，应与加密时使用的密钥相同，范围0到25。
     * @return 返回解密后的明文字符串。
     */
    public static String decrypt(String ciphertext, int key) {
//       相当于将加密密钥倒过来计算回原文。
        // 解密过程实质上是使用了调整后的密钥（26减去原密钥的余数）进行加密
        return encrypt(ciphertext, 26 - (key % 26));
    }

//    21401070207-软工2102-李长辉
    public static void main(String[] args) {
//       密钥
        int key = 3;
        // 测试加密功能
        String plaintext = "Once upon a sunny day in a little village called Harmonyville, there lived a curious rabbit named Benny. Benny had soft, fluffy ears and a nose that twitched with excitement at every new smell. He was known for his love of adventure and his insatiable curiosity.One morning, as Benny hopped through the meadows, he spotted something glittering under the rays of the rising sun. It was a tiny, golden key, partially hidden among the tall blades of grass. His eyes widened with wonder, and without a second thought, he picked it up, wondering what treasure it might unlock.With the key securely clenched between his teeth, Benny set off on a quest to find its matching lock. He asked the wise old owl, who perched high in the oak tree, if she knew of any secret locks in Harmonyville. The owl blinked her big, round eyes and thoughtfully hooted, \"Young Benny, the key you hold is ancient; its story is whispered by the wind through the branches of the oldest tree in the forest.\"";
        System.out.println("加密: " + encrypt(plaintext, key)); // 预期输出: EHLGDR23
        // 测试解密功能
        String encrypted = "EHLGDR23";
        System.out.println("解密: " + decrypt(encrypted, key)); // 预期输出: BEIDAO23
        System.out.println();


        // 测试加密功能
        String plaintext2 = "BEIDAO23";
        System.out.println("加密: " + encrypt(plaintext2, key)); // 预期输出: EHLGDR23
        // 测试解密功能
        String encrypted3 = "EHLGDR23";
        System.out.println("解密: " + decrypt(encrypted3, key)); // 预期输出: BEIDAO23
        System.out.println();


        // 测试包含大小写字母及标点的文本
        String mixedCase = "QIFEI.QIFEI..";
        System.out.println("原文: " + mixedCase);
        String encryptedMixed = encrypt(mixedCase, key);
        System.out.println("加密: " + encryptedMixed);
        System.out.println("解密: " + decrypt(encryptedMixed, key));
        System.out.println();

        // 测试包含字母和数字
        String mixnumw = "i am changhui,age:23";
        System.out.println("原文: " + mixnumw);
        String mixnumw2 = encrypt(mixnumw, key);
        System.out.println("加密: " + mixnumw2);
        System.out.println("解密: " + decrypt(mixnumw2, key));

        // 测试含有特殊字符和数字的文本
        String specialChars = "beidaomitu@233zz!";
        System.out.println("\n原文: " + specialChars);
        String encryptedSpecial = encrypt(specialChars, key);
        System.out.println("加密: " + encryptedSpecial);
        System.out.println("解密: " + decrypt(encryptedSpecial, key));

    }
}


