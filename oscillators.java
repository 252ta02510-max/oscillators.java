// ==========================================================
//              OSCILLATORS SIMULATION IN JAVA
// ==========================================================
// Simulates:
// 1. Sine Wave Oscillator
// 2. Square Wave Oscillator
// 3. Triangle Wave Oscillator
// 4. Sawtooth Wave Oscillator
// ==========================================================

import java.util.Scanner;

public class Oscillators {

    // ------------------------------------------------------
    // SINE WAVE
    // ------------------------------------------------------
    public static double sineWave(
            double amplitude,
            double frequency,
            double time) {

        return amplitude *
               Math.sin(2 * Math.PI * frequency * time);
    }


    // ------------------------------------------------------
    // SQUARE WAVE
    // ------------------------------------------------------
    public static double squareWave(
            double amplitude,
            double frequency,
            double time) {

        double value =
                Math.sin(2 * Math.PI * frequency * time);

        if (value >= 0) {
            return amplitude;
        } else {
            return -amplitude;
        }
    }


    // ------------------------------------------------------
    // TRIANGLE WAVE
    // ------------------------------------------------------
    public static double triangleWave(
            double amplitude,
            double frequency,
            double time) {

        double value =
                Math.sin(2 * Math.PI * frequency * time);

        return (2 * amplitude / Math.PI)
                * Math.asin(value);
    }


    // ------------------------------------------------------
    // SAWTOOTH WAVE
    // ------------------------------------------------------
    public static double sawtoothWave(
            double amplitude,
            double frequency,
            double time) {

        double value =
                frequency * time;

        return 2 * amplitude *
                (value - Math.floor(value + 0.5));
    }


    // ------------------------------------------------------
    // PRINT WAVEFORM VALUES
    // ------------------------------------------------------
    public static void printWaveforms(
            double amplitude,
            double frequency,
            double duration,
            int samples) {

        System.out.println();
        System.out.println(
                "=============================================================="
        );

        System.out.println(
                "                  OSCILLATOR WAVEFORMS"
        );

        System.out.println(
                "=============================================================="
        );

        System.out.printf(
                "%-10s %-12s %-12s %-12s %-12s%n",
                "Time",
                "Sine",
                "Square",
                "Triangle",
                "Sawtooth"
        );

        System.out.println(
                "--------------------------------------------------------------"
        );

        double timeStep =
                duration / samples;

        for (int i = 0; i <= samples; i++) {

            double time =
                    i * timeStep;

            double sine =
                    sineWave(
                            amplitude,
                            frequency,
                            time
                    );

            double square =
                    squareWave(
                            amplitude,
                            frequency,
                            time
                    );

            double triangle =
                    triangleWave(
                            amplitude,
                            frequency,
                            time
                    );

            double sawtooth =
                    sawtoothWave(
                            amplitude,
                            frequency,
                            time
                    );

            System.out.printf(
                    "%-10.3f %-12.3f %-12.3f %-12.3f %-12.3f%n",
                    time,
                    sine,
                    square,
                    triangle,
                    sawtooth
            );
        }
    }


    // ------------------------------------------------------
    // DISPLAY OSCILLATOR INFORMATION
    // ------------------------------------------------------
    public static void displayInformation(
            double amplitude,
            double frequency) {

        double period =
                1.0 / frequency;

        double angularFrequency =
                2 * Math.PI * frequency;

        System.out.println();
        System.out.println(
                "=============================================================="
        );

        System.out.println(
                "                OSCILLATOR INFORMATION"
        );

        System.out.println(
                "=============================================================="
        );

        System.out.println(
                "Amplitude          : "
                        + amplitude + " V"
        );

        System.out.println(
                "Frequency          : "
                        + frequency + " Hz"
        );

        System.out.println(
                "Time Period        : "
                        + period + " seconds"
        );

        System.out.println(
                "Angular Frequency  : "
                        + angularFrequency + " rad/sec"
        );

        System.out.println(
                "=============================================================="
        );
    }


    // ------------------------------------------------------
    // DISPLAY OSCILLATOR TYPES
    // ------------------------------------------------------
    public static void displayTypes() {

        System.out.println();
        System.out.println(
                "=============================================================="
        );

        System.out.println(
                "                    OSCILLATOR TYPES"
        );

        System.out.println(
                "=============================================================="
        );

        System.out.println(
                "1. Sine Wave Oscillator"
        );

        System.out.println(
                "   Produces a sinusoidal waveform."
        );

        System.out.println();

        System.out.println(
                "2. Square Wave Oscillator"
        );

        System.out.println(
                "   Produces a rectangular waveform."
        );

        System.out.println();

        System.out.println(
                "3. Triangle Wave Oscillator"
        );

        System.out.println(
                "   Produces a triangular waveform."
        );

        System.out.println();

        System.out.println(
                "4. Sawtooth Wave Oscillator"
        );

        System.out.println(
                "   Produces a linearly rising and falling waveform."
        );

        System.out.println(
                "=============================================================="
        );
    }


    // ------------------------------------------------------
    // MENU
    // ------------------------------------------------------
    public static void displayMenu() {

        System.out.println();
        System.out.println(
                "=============================================================="
        );

        System.out.println(
                "                 OSCILLATOR SIMULATOR"
        );

        System.out.println(
                "=============================================================="
        );

        System.out.println(
                "1. Display Oscillator Information"
        );

        System.out.println(
                "2. Generate Sine Wave"
        );

        System.out.println(
                "3. Generate Square Wave"
        );

        System.out.println(
                "4. Generate Triangle Wave"
        );

        System.out.println(
                "5. Generate Sawtooth Wave"
        );

        System.out.println(
                "6. Display All Waveforms"
        );

        System.out.println(
                "7. Display Oscillator Types"
        );

        System.out.println(
                "8. Exit"
        );

        System.out.println(
                "=============================================================="
        );
    }


    // ------------------------------------------------------
    // MAIN METHOD
    // ------------------------------------------------------
    public static void main(String[] args) {

        Scanner scanner =
                new Scanner(System.in);

        double amplitude = 5.0;
        double frequency = 5.0;
        double duration = 2.0;

        int samples = 20;

        System.out.println();
        System.out.println(
                "**************************************************************"
        );

        System.out.println(
                "              OSCILLATORS PROGRAM IN JAVA"
        );

        System.out.println(
                "**************************************************************"
        );

        System.out.println(
                "This program demonstrates different oscillator waveforms."
        );


        // --------------------------------------------------
        // USER PARAMETERS
        // --------------------------------------------------

        System.out.print(
                "\nEnter amplitude in volts (default 5): "
        );

        String ampInput =
                scanner.nextLine();

        if (!ampInput.isEmpty()) {

            try {

                amplitude =
                        Double.parseDouble(ampInput);

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid value. Using 5 V."
                );

                amplitude = 5.0;
            }
        }


        System.out.print(
                "Enter frequency in Hz (default 5): "
        );

        String freqInput =
                scanner.nextLine();

        if (!freqInput.isEmpty()) {

            try {

                frequency =
                        Double.parseDouble(freqInput);

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid value. Using 5 Hz."
                );

                frequency = 5.0;
            }
        }


        // --------------------------------------------------
        // MAIN MENU LOOP
        // --------------------------------------------------

        boolean running = true;

        while (running) {

            displayMenu();

            System.out.print(
                    "Enter your choice: "
            );

            int choice;

            try {

                choice =
                        Integer.parseInt(
                                scanner.nextLine()
                        );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid choice!"
                );

                continue;
            }


            switch (choice) {

                case 1:

                    displayInformation(
                            amplitude,
                            frequency
                    );

                    break;


                case 2:

                    System.out.println();
                    System.out.println(
                            "SINE WAVE VALUES"
                    );

                    System.out.println(
                            "-----------------------------"
                    );

                    for (int i = 0; i <= samples; i++) {

                        double time =
                                i * duration / samples;

                        double value =
                                sineWave(
                                        amplitude,
                                        frequency,
                                        time
                                );

                        System.out.printf(
                                "Time = %.3f s   Output = %.3f V%n",
                                time,
                                value
                        );
                    }

                    break;


                case 3:

                    System.out.println();
                    System.out.println(
                            "SQUARE WAVE VALUES"
                    );

                    System.out.println(
                            "-----------------------------"
                    );

                    for (int i = 0; i <= samples; i++) {

                        double time =
                                i * duration / samples;

                        double value =
                                squareWave(
                                        amplitude,
                                        frequency,
                                        time
                                );

                        System.out.printf(
                                "Time = %.3f s   Output = %.3f V%n",
                                time,
                                value
                        );
                    }

                    break;


                case 4:

                    System.out.println();
                    System.out.println(
                            "TRIANGLE WAVE VALUES"
                    );

                    System.out.println(
                            "-----------------------------"
                    );

                    for (int i = 0; i <= samples; i++) {

                        double time =
                                i * duration / samples;

                        double value =
                                triangleWave(
                                        amplitude,
                                        frequency,
                                        time
                                );

                        System.out.printf(
                                "Time = %.3f s   Output = %.3f V%n",
                                time,
                                value
                        );
                    }

                    break;


                case 5:

                    System.out.println();
                    System.out.println(
                            "SAWTOOTH WAVE VALUES"
                    );

                    System.out.println(
                            "-----------------------------"
                    );

                    for (int i = 0; i <= samples; i++) {

                        double time =
                                i * duration / samples;

                        double value =
                                sawtoothWave(
                                        amplitude,
                                        frequency,
                                        time
                                );

                        System.out.printf(
                                "Time = %.3f s   Output = %.3f V%n",
                                time,
                                value
                        );
                    }

                    break;


                case 6:

                    printWaveforms(
                            amplitude,
                            frequency,
                            duration,
                            samples
                    );

                    break;


                case 7:

                    displayTypes();

                    break;


                case 8:

                    running = false;

                    System.out.println();
                    System.out.println(
                            "Oscillator simulation completed."
                    );

                    break;


                default:

                    System.out.println(
                            "Invalid choice. Please select 1 to 8."
                    );
            }
        }


        // --------------------------------------------------
        // CLOSE SCANNER
        // --------------------------------------------------

        scanner.close();

        System.out.println();
        System.out.println(
                "**************************************************************"
        );

        System.out.println(
                "                     END OF PROGRAM"
        );

        System.out.println(
                "**************************************************************"
        );
    }
}
