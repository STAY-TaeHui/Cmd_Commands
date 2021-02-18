
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
 
public class test {
    static String defaultPath = "C:"+File.separator+"Temp2" + File.separator;
    static String path = defaultPath;
 
    public static void main(String[] args) {
        System.out.println("         이클립스에서 그냥 실행 해볼 수 있는 간단한 DOS 커맨드\r\n"
                + "         사용할 수 있는 명령어\r\n"
                + " \r\n"
                + "    \r\n"
                + "         MD 디렉터리를 만듭니다.\r\n"
                + "         MKDIR 디렉터리를 만듭니다.\r\n"
                + "         RD 디렉터리를 지웁니다.\r\n"
                + "         RMDIR 디렉터리를 지웁니다.\r\n"
                + "         REN 파일 이름을 바꿉니다.\r\n"
                + "         RENAME파일 이름을 바꿉니다.");
        System.out.println("-----------------------------------------------------------");
     
 
        Scanner sc = new Scanner(System.in);
 
        String[] input = null;
 
        while (true) {
            System.out.print(path + ">");
            input = sc.nextLine().split(" "); //출력
 
            if (input[0].equalsIgnoreCase("exit")) {
                System.exit(0);
                return;
            }
 
            if (!input[0].equals("")) {
                if (input[0].equalsIgnoreCase("dir")) {
                    searchDirectory(input);
                } else if (input[0].equalsIgnoreCase("cd")) {
                    changeDirectory(input);
                } else if (input[0].equalsIgnoreCase("cd..")) {
                    changeDirectory(input);
                } else if (input[0].equalsIgnoreCase("md")
                        || input[0].equalsIgnoreCase("mkdir")) {
                    if(input.length>=2)
                    makeDirectory(input);
                    }
                else if (input[0].equalsIgnoreCase("rd")
                        || input[0].equalsIgnoreCase("rmdir")) {
                    File file = null;
                    if (input.length <= 1) {
                        System.out.println("명령 구문이 올바르지 않습니다.");
                    } else if (input.length == 2) {
                        String pathTemp = defaultPath;
 
                        if (!path.equals(defaultPath)) {
                            pathTemp = path + File.separator + input[1];
                        } else {
                            pathTemp = defaultPath + File.separator + input[1];
                        }
 
                        file = new File(pathTemp);
                        if (!deleteDirectory(file)) {
                            System.out.println("지정된 파일을 찾을 수 없습니다.");
                        }
                    }
                } else if (input[0].equalsIgnoreCase("ren")
                        || input[0].equalsIgnoreCase("rename")) {
                    renameDirectory(input);
                } else if (input[0].equalsIgnoreCase("type")) {
                    readTextFile(input);
                } else if (input[0].equalsIgnoreCase("help")) {
                    displayHelp(input);
                } else {
                    System.out.println("'"
                                    + input[0]
                                    + "'은(는) 내부 또는 외부 명령, 실행할 수 있는 프로그램, 또는 배치 파일이 아닙니다");
                }
                System.out.println();
            }
 
        }
 
    }

    private static void makeDirectory(String[] input) {
        // TODO Auto-generated method stub
        System.out.println("This is makeDirectory");

        File file = new File(path + input[1]);
        
        if(!file.exists())
            {
                try{
                    file.mkdir();
                    System.out.println("디렉터리가 생성되었습니다.");
                }
                catch(Exception e) {
                    
                }
            }  
        else
        {
            System.out.println("동일한 이름의 파일이 이미 존재합니다.");
        }
    }

    private static void displayHelp(String[] input) {
        // TODO Auto-generated method stub
        
    }

    private static void readTextFile(String[] input) {
        // TODO Auto-generated method stub
        
    }

    private static void renameDirectory(String[] input) {
        // TODO Auto-generated method stub
        
    }

    private static void changeDirectory(String[] input) {
        // TODO Auto-generated method stub
        
    }

    private static void searchDirectory(String[] input) {
        // TODO Auto-generated method stub
        
    }

    private static boolean deleteDirectory(File file) {
        // TODO Auto-generated method stub
        System.out.println("This is deleteDirectory");
        System.out.println("지워질 디렉터리의 이름은 : " + file.getName());
        
        return file.delete() ? true : false;
    }
}