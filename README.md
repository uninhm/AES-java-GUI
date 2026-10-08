# AES-java-GUI
GUI for the AES-java library.

## How to build

This project is built with Maven and requires JDK 21 or newer.

1. Install Java 21 and Maven.
2. Install [AES-java](https://github.com/uninhm/AES-java#Install-with-Maven) (i.e. run `mvn install` that project's source folder).
3. Open a terminal in the project root.
4. Run:

```bash
mvn clean package
```

This creates an executable JAR in `target/` with dependencies included. The generated file is typically:

```bash
target/AES-java-GUI-1.0-SNAPSHOT-jar-with-dependencies.jar
```

## How to use
You can get the program either by building it youself or via the JAR provided in the releases. Then you can run something like (depending on the file's name and location):
```bash
java -jar AES-java-GUI-1.0-SNAPSHOT-jar-with-dependencies.jar
```

### Settings
Beware: The **current settings** will be used when loading a file. Select you wanted mode (encrypt/decrypt), charset or eventually binary file mode before loading the file.

#### Charset
In the settings you can change the charset that will be used when loading a textfile, encoding the text before encrypting, and after decrypting.  
Notice you can select one charset, import a file, and then choose another charset for the encryption.

#### Padding
You can also select the padding method. I hightly recommend that you use the default one.

#### Binary file mode
Enable this option if the file you want to encrypt is not a text file. This will skip the charset encoding and prevent the preview from showing (which could take a long time or not work if the file is too big).

### Usage

#### Encrypting
Once you have chosen all the settings, you can import a file. If you're in text mode, you will be able to edit the content before encrypting. Then you can save the result into a file using the "Save" button.  
You can also write directly into the text area instead of importing a file.

#### Decrypting
Once you have chosen all the settings, you can import a file. If you're in text mode, the file preview will be shown as the hexadecimal representation of the encrypted bytes.  
You can also paste the hex directly into the text area instead of importing a file.