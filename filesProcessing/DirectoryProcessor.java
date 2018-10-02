package filesprocessing; /**
 * Created by hagitba on 5/28/17.
 */

import Filter.*;
import Order.Abs;
import Order.Size;
import Order.Type;
import Exception.*;

import java.io.*;
import java.util.*;

/**
 * This class is the main class ,which gets a command line and according to it
 * creates filter and order objects to print the wanted files.
 */
public class DirectoryProcessor {


    private static FileFilter filterObject;
    private static Comparator<File> orderObject;
    private static boolean isBad, noOrderDescription, isNo;
    private static boolean isReversed = false;
    private static int lineCounter;
    public static final String EMPTY_STRING= "";


    /**
     * this function creates files object and analyze the command line
     *
     * @param args command lines whith two arguments
     */
    public static void commandLineAnalyzer(String[] args) {

        if (args.length != 2) {
            System.err.println("ERROR: wrong number of arguments \n");
        }
        String path = args[0];
        File[] folder = new File(path).listFiles();
        List<File> files = new ArrayList<File>();

        for (File file : folder) { // insert all the files into the list
            if (file.isFile()) {
                files.add(file);
            }
        }

        try {
            readFileLines(args[1], files);
        } catch (IOException e) {
            System.err.println("NoSuchFileException");
        } catch (Type2Error e2) {
            System.err.println("ERROR: Bad sub-section name \n");
        }

    }


    /**
     * this function gets the filter file's path and reading it line by line in order to filter and order
     * the relevant files
     *
     * @param path  the filter file's path
     * @param files all the files that were given by the user
     * @throws IOException         this exception is for error in opening the file
     * @throws SubSectionException this exception is for error from type 2
     */
    public static void readFileLines(String path, List<File> files) throws IOException, SubSectionException{

        FileInputStream openFile;
        try {
            openFile = new FileInputStream(path);
        } catch (IOException e) {
            throw e;
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(openFile));
        String line = EMPTY_STRING;

        while (line != null) {  // the while loop checks if there are errors of type 2

            if (!line.equals("FILTER")) {
                line = br.readLine();
            }
            if (line == null) {
                break;
            }
            if (line == null || !(line.equals("FILTER"))) {
                throw new SubSectionException("ERROR: Bad sub-section name \n");
            }

            line = br.readLine();
            line = br.readLine();


            if (line == null || !(line.equals("ORDER"))) {
                throw new SubSectionException("ERROR: Bad sub-section name \n");
            }

            line = br.readLine();

        }

        br.mark(0);
        br.reset();
        lineCounter = 0;

        while ((line = br.readLine()) != null) { // this while loop is for reading the file

            List<File> filteredFiles = new ArrayList<File>();

            line = br.readLine();
            lineCounter += 1;


            FileFilter createdFilter = filterObjectCreation(line);

            for (File file : files) { // insert all the relevant files into the list
                if (createdFilter.accept(file)) {
                    filteredFiles.add(file);
                }
            }


            line = br.readLine();
            lineCounter += 1;

            line = br.readLine();
            lineCounter += 1;

            createOrderObject(line);

            try {
                printByOrder(filteredFiles);
            } catch (Exception exception) {

            }
        }
    }

    /**
     * check whether or not there is NOT hashtag in the filter description
     *
     * @param value part of the filter's description
     * @return true if there is NOT hastag ,false else
     */
    public static boolean checkIsNot(String value) {
        boolean isNot = false;

        if (value != null) {
            if (value.equals("NOT")) {
                isNot = true;
            }
        } else {
            isNot = false;
        }
        return isNot;
    }

    /**
     * check whether or not there is NO hashtag in the filter description
     *
     * @param value part of the filter's description
     * @return true if there is NO hastag ,false else
     */
    public static boolean checkIsNo(String value) {

        if (value.equals("NO")) {
            isNo = true;
        } else {
            isNo = false;
            if (!value.equals("YES")) {
                isBad = true;
            }
        }
        return isNo;
    }


    /**
     * this function filter object according to what was written in the FILTER description
     *
     * @param filterLine the filter's description
     * @return the filter object
     */
    public static FileFilter filterObjectCreation(String filterLine) {

        String[] parts = filterLine.split("#");

        String filterName = parts[0];


        boolean isNot = false;

        switch (filterName) { // create a filter object by the given 'filter name'
            case "all": {
                filterObject = new All();
            }
            break;

            case "between": {
                double part1 = Double.parseDouble(parts[1]);
                if (parts.length == 4)
                    isNot = checkIsNot(parts[3]);
                if ((parts.length >= 3)) {
                    double part2 = Double.parseDouble(parts[2]);

                    if (part1 >= 0 && part2 >= 0 && part2 >= part1) {
                        filterObject = new Between(part1, part2, isNot);
                    } else {
                        System.err.println("Warning in line " + lineCounter);
                    }
                }
            }
            break;

            case "greater_than": {
                double part1 = Double.parseDouble(parts[1]);

                if (parts.length >= 3) {
                    isNot = checkIsNot(parts[2]);
                }
                if (part1 >= 0) {
                    filterObject = new GreaterThan(part1, isNot);
                } else {
                    System.err.println("Warning in line " + lineCounter);
                }
            }
            break;

            case "smaller_than": {
                double part1 = Double.parseDouble(parts[1]);
                if (parts.length >= 3) {
                    isNot = checkIsNot(parts[2]);
                }
                if (part1 >= 0) {
                    filterObject = new SmallerThan(part1, isNot);
                } else {
                    System.err.println("Warning in line " + lineCounter);
                }
            }
            break;

            case "contains": {
                isNot = checkIsNot(parts[2]);

                filterObject = new Contains(parts[1], isNot);
            }
            break;

            case "executable": {
                if (parts.length >= 3) {
                    isNot = checkIsNot(parts[2]);
                }
                isNo = checkIsNo(parts[1]);
                if (isBad) {
                    isBad = false;
                    System.err.println("Warning in line " + lineCounter);
                }
                filterObject = new Executable(isNo, isNot);
            }
            break;

            case "file": {
                if (parts.length >= 3)
                    isNot = checkIsNot(parts[2]);

                filterObject = new FileName(parts[1], isNot);
            }
            break;

            case "hidden": {
                if (parts.length >= 3) {
                    isNot = checkIsNot(parts[2]);
                }
                isNo = checkIsNo(parts[1]);
                if (isBad) {
                    isBad = false;
                    System.err.println("Warning in line " + lineCounter);
                }
                filterObject = new Hidden(isNo, isNot);
            }
            break;

            case "prefix": {
                if (parts.length >= 3)
                    isNot = checkIsNot(parts[2]);

                filterObject = new Prefix(parts[1], isNot);
            }
            break;

            case "suffix": {
                if (parts.length >= 3)
                    isNot = checkIsNot(parts[2]);

                filterObject = new Suffix(parts[1], isNot);
            }
            break;

            case "writable": {
                if (parts.length >= 3) {
                    isNot = checkIsNot(parts[2]);
                }
                isNo = checkIsNo(parts[1]);
                if (isBad) {
                    isBad = false;
                    System.err.println("Warning in line " + lineCounter);
                }
                filterObject = new Writable(isNo, isNot);
            }
            break;

            default:
                filterObject = new All();
                System.err.println("Warning in line " + lineCounter);
        }
        return filterObject;
    }


    /**
     * this function creates ORDER object according to what was written in the ORDER description
     *
     * @param orderLine the ORDER description
     */
    public static void createOrderObject(String orderLine) {

        String[] parts = orderLine.split("#");

        String orderName = parts[0];


        switch (orderName) { // create a order object by the given 'order name'
            case "abs": {
                if (parts.length >= 2) {
                    if (parts[1].equals("REVERSE")) {
                        isReversed = true;
                    }
                } else {
                    isReversed = false;
                }
                orderObject = new Abs(isReversed);
            }
            break;

            case "size": {
                if (parts.length >= 2) {
                    if (parts[1].equals("REVERSE")) {
                        isReversed = true;
                    }
                } else {
                    isReversed = false;
                }
                orderObject = new Size(isReversed);
            }
            break;

            case "type": {
                if (parts.length >= 2) {
                    if (parts[1].equals("REVERSE")) {
                        isReversed = true;
                    }
                } else {
                    isReversed = false;
                }
                orderObject = new Type(isReversed);
            }
            break;

            case "FILTER": {//that's mean that there is no order description
                noOrderDescription = true;

            }

            default:
                orderObject = new Abs(false);
                System.err.println("Warning in line " + lineCounter);
        }
    }

    /**
     * prints the relevant files according to the order that was demanded
     *
     * @param files the files that have been asked to be printed
     */
    public static void printByOrder(List<File> files) throws ClassCastException, IllegalArgumentException {

        Abs abs = new Abs(isReversed);
        Collections.sort(files, orderObject.thenComparing(abs));
        for (File file : files) {
            System.out.println(file.getName());
        }
    }


    public static void main(String args[]) {
        commandLineAnalyzer(args);
    }
}
