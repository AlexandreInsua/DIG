package exerciciosCasa06;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;

public class Main {

	private JFrame frame;

	private JLabel lblTimeHours;
	private JLabel lblTimeMinutes;
	private JLabel lblTimeSeconds;
	private JLabel lblChronoMinutes;
	private JLabel lblChronoSeconds;
	private JLabel lblChronoCentiseconds;
	private JSpinner spinnerTimerHours;
	private JSpinner spinnerTimerMinutes;
	private JSpinner spinnerTimerSeconds;
	private JButton btnChronoReset;
	private JToggleButton btnChronoStartStop;

	Timer timerTime = new Timer();
	Timer timerChrono = new Timer();
	Timer timerTimer = new Timer();
	boolean timerWorking = false;
	private JToggleButton btnTimerStartStop;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
		TimerTask task = new TimerTask() {
			public void run() {
				LocalTime lt = LocalTime.now();
				lblTimeHours.setText(String.valueOf(lt.getHour()));
				lblTimeMinutes.setText(String.valueOf(lt.getMinute()));
				lblTimeSeconds.setText(String.valueOf(lt.getSecond()));
			}
		};
		timerTime.scheduleAtFixedRate(task, 0, 1000);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);

		JPanel panelTime = new JPanel();
		panelTime.setBackground(Color.DARK_GRAY);
		tabbedPane.addTab("Reloj", new ImageIcon(Main.class.getResource("time.png")), panelTime, null);
		panelTime.setLayout(new GridLayout(1, 0, 0, 0));

		lblTimeHours = new JLabel("0");
		lblTimeHours.setForeground(Color.WHITE);
		lblTimeHours.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTimeHours.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblTimeHours.setHorizontalAlignment(SwingConstants.CENTER);
		panelTime.add(lblTimeHours);

		JLabel lblTimeHoursMinutes = new JLabel(":");
		lblTimeHoursMinutes.setForeground(Color.WHITE);
		lblTimeHoursMinutes.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTimeHoursMinutes.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblTimeHoursMinutes.setHorizontalAlignment(SwingConstants.CENTER);
		panelTime.add(lblTimeHoursMinutes);

		lblTimeMinutes = new JLabel("0");
		lblTimeMinutes.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimeMinutes.setForeground(Color.WHITE);
		lblTimeMinutes.setFont(new Font("Tahoma", Font.BOLD, 20));
		panelTime.add(lblTimeMinutes);

		JLabel lblTimeMinutesSeconds = new JLabel(":");
		lblTimeMinutesSeconds.setForeground(Color.WHITE);
		lblTimeMinutesSeconds.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTimeMinutesSeconds.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimeMinutesSeconds.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelTime.add(lblTimeMinutesSeconds);

		lblTimeSeconds = new JLabel("0");
		lblTimeSeconds.setForeground(Color.WHITE);
		lblTimeSeconds.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTimeSeconds.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblTimeSeconds.setHorizontalAlignment(SwingConstants.CENTER);
		panelTime.add(lblTimeSeconds);

		JPanel panelChrono = new JPanel();
		tabbedPane.addTab("Cron\u00F3metro", new ImageIcon(Main.class.getResource("chrono.png")), panelChrono, null);
		panelChrono.setLayout(new BorderLayout(0, 0));

		JPanel panelChronoLabels = new JPanel();
		panelChrono.add(panelChronoLabels, BorderLayout.CENTER);
		panelChronoLabels.setLayout(new GridLayout(1, 0, 0, 0));

		lblChronoMinutes = new JLabel("0");
		lblChronoMinutes.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblChronoMinutes.setHorizontalAlignment(SwingConstants.CENTER);
		lblChronoMinutes.setFont(new Font("Tahoma", Font.BOLD, 20));
		panelChronoLabels.add(lblChronoMinutes);

		JLabel lblChronoMinutesSeconds = new JLabel(":");
		lblChronoMinutesSeconds.setHorizontalAlignment(SwingConstants.CENTER);
		lblChronoMinutesSeconds.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblChronoMinutesSeconds.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelChronoLabels.add(lblChronoMinutesSeconds);

		lblChronoSeconds = new JLabel("0");
		lblChronoSeconds.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblChronoSeconds.setHorizontalAlignment(SwingConstants.CENTER);
		lblChronoSeconds.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelChronoLabels.add(lblChronoSeconds);

		JLabel lblChronoSecondsCentiSeconds = new JLabel(",");
		lblChronoSecondsCentiSeconds.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblChronoSecondsCentiSeconds.setHorizontalAlignment(SwingConstants.CENTER);
		lblChronoSecondsCentiSeconds.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelChronoLabels.add(lblChronoSecondsCentiSeconds);

		lblChronoCentiseconds = new JLabel("0");
		lblChronoCentiseconds.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblChronoCentiseconds.setHorizontalAlignment(SwingConstants.CENTER);
		lblChronoCentiseconds.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelChronoLabels.add(lblChronoCentiseconds);

		JPanel panelChronoButtons = new JPanel();
		panelChrono.add(panelChronoButtons, BorderLayout.SOUTH);

		btnChronoReset = new JButton("Reiniciar");
		btnChronoReset.setIcon(new ImageIcon(Main.class.getResource("reset.png")));
		btnChronoReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetChrono();
			}
		});
		panelChronoButtons.add(btnChronoReset);

		btnChronoStartStop = new JToggleButton("Iniciar");
		btnChronoStartStop.setIcon(new ImageIcon(Main.class.getResource("play.png")));
		btnChronoStartStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				startStopChrono();
			}
		});
		panelChronoButtons.add(btnChronoStartStop);

		JPanel panelTimer = new JPanel();
		tabbedPane.addTab("Temporizador", new ImageIcon(Main.class.getResource("timer.png")), panelTimer, null);
		panelTimer.setLayout(new BorderLayout(0, 0));

		JPanel panelTimerSpinners = new JPanel();
		panelTimer.add(panelTimerSpinners, BorderLayout.CENTER);
		panelTimerSpinners.setLayout(new GridLayout(1, 0, 0, 0));

		spinnerTimerHours = new JSpinner();
		spinnerTimerHours.setFont(new Font("Tahoma", Font.BOLD, 20));
		spinnerTimerHours.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		panelTimerSpinners.add(spinnerTimerHours);

		JLabel lblTimerHoursMinutes = new JLabel(":");
		lblTimerHoursMinutes.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTimerHoursMinutes.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimerHoursMinutes.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelTimerSpinners.add(lblTimerHoursMinutes);

		spinnerTimerMinutes = new JSpinner();
		spinnerTimerMinutes.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		spinnerTimerMinutes.setFont(new Font("Tahoma", Font.BOLD, 20));
		panelTimerSpinners.add(spinnerTimerMinutes);

		JLabel lblTimersMinutesSeconds = new JLabel(":");
		lblTimersMinutesSeconds.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTimersMinutesSeconds.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblTimersMinutesSeconds.setHorizontalAlignment(SwingConstants.CENTER);
		panelTimerSpinners.add(lblTimersMinutesSeconds);

		spinnerTimerSeconds = new JSpinner();
		spinnerTimerSeconds.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		spinnerTimerSeconds.setFont(new Font("Tahoma", Font.BOLD, 20));
		panelTimerSpinners.add(spinnerTimerSeconds);

		JPanel panelTimerButtons = new JPanel();
		panelTimer.add(panelTimerButtons, BorderLayout.SOUTH);

		JButton btnTimerReset = new JButton("Reiniciar");
		btnTimerReset.setIcon(new ImageIcon(Main.class.getResource("reset.png")));
		btnTimerReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetTimer();
			}
		});
		panelTimerButtons.add(btnTimerReset);

		btnTimerStartStop = new JToggleButton("Iniciar");
		btnTimerStartStop.setIcon(new ImageIcon(Main.class.getResource("play.png")));
		btnTimerStartStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startStopTimer();
			}
		});
		panelTimerButtons.add(btnTimerStartStop);
	}

	private void startStopChrono() {
		if (btnChronoStartStop.getText().equals("Iniciar")) {
			timerChrono = new Timer();
			TimerTask task = new TimerTask() {
				public void run() {
					int chronoMinutes = Integer.valueOf(lblChronoMinutes.getText());
					int chronoSeconds = Integer.valueOf(lblChronoSeconds.getText());
					int chronoCentiseconds = Integer.valueOf(lblChronoCentiseconds.getText());
					chronoCentiseconds++;
					if (chronoCentiseconds >= 100) {
						chronoCentiseconds = 0;
						chronoSeconds++;
					}
					if (chronoSeconds >= 60) {
						chronoSeconds = 0;
						chronoMinutes++;
					}
					lblChronoMinutes.setText(String.valueOf(chronoMinutes));
					lblChronoSeconds.setText(String.valueOf(chronoSeconds));
					lblChronoCentiseconds.setText(String.valueOf(chronoCentiseconds));
				}
			};
			timerChrono.scheduleAtFixedRate(task, 0, 10);
			btnChronoStartStop.setText("Detener");
			btnChronoStartStop.setIcon(new ImageIcon(Main.class.getResource("stop.png")));
			btnChronoStartStop.setSelected(true);
		} else if (btnChronoStartStop.getText().equals("Detener")) {
			timerChrono.cancel();
			btnChronoStartStop.setText("Iniciar");
			btnChronoStartStop.setIcon(new ImageIcon(Main.class.getResource("play.png")));
			btnChronoStartStop.setSelected(false);
		}
	}

	private void resetChrono() {
		timerChrono.cancel();
		lblChronoMinutes.setText("0");
		lblChronoSeconds.setText("0");
		lblChronoCentiseconds.setText("0");
		btnChronoStartStop.setText("Iniciar");
		btnChronoStartStop.setIcon(new ImageIcon(Main.class.getResource("play.png")));
		btnChronoStartStop.setSelected(false);
	}

	private void startStopTimer() {
		if (btnTimerStartStop.getText().equals("Iniciar")) {
			timerTimer = new Timer();
			TimerTask task = new TimerTask() {
				public void run() {
					int timerHours = (int) spinnerTimerHours.getValue();
					int timerMinutes = (int) spinnerTimerMinutes.getValue();
					int timerSeconds = (int) spinnerTimerSeconds.getValue();
					if (timerHours == 0 && timerMinutes == 0 && timerSeconds == 0) {
						playSound();
						btnTimerStartStop.setText("Iniciar");
						btnTimerStartStop.setIcon(new ImageIcon(Main.class.getResource("play.png")));
						btnTimerStartStop.setSelected(false);
						cancel();
					} else if (timerSeconds > 0) {
						timerSeconds--;
					} else if (timerMinutes > 0) {
						timerMinutes--;
						timerSeconds = 59;
					} else if (timerHours > 0) {
						timerHours--;
						timerMinutes = 59;
						timerSeconds = 59;
					}
					spinnerTimerHours.setValue(timerHours);
					spinnerTimerMinutes.setValue(timerMinutes);
					spinnerTimerSeconds.setValue(timerSeconds);
				}
			};
			timerTimer.scheduleAtFixedRate(task, 0, 1000);
			btnTimerStartStop.setText("Detener");
			btnTimerStartStop.setIcon(new ImageIcon(Main.class.getResource("stop.png")));
			btnTimerStartStop.setSelected(true);
		} else if (btnTimerStartStop.getText().equals("Detener")) {
			timerTimer.cancel();
			btnTimerStartStop.setText("Iniciar");
			btnTimerStartStop.setIcon(new ImageIcon(Main.class.getResource("play.png")));
			btnTimerStartStop.setSelected(false);
		}
	}

	private void resetTimer() {
		timerTimer.cancel();
		spinnerTimerHours.setValue(0);
		spinnerTimerMinutes.setValue(0);
		spinnerTimerSeconds.setValue(0);
		btnTimerStartStop.setText("Iniciar");
		btnTimerStartStop.setIcon(new ImageIcon(Main.class.getResource("play.png")));
		btnTimerStartStop.setSelected(false);
	}

	private void playSound() {
		File soundFile = new File("alarm.wav");
		AudioInputStream sound = null;
		try {
			sound = AudioSystem.getAudioInputStream(soundFile);
			// DataLine.Info info = new DataLine.Info(Clip.class,
			// sound.getFormat());
			// Clip clip = (Clip) AudioSystem.getLine(info);
			Clip clip = AudioSystem.getClip();
			clip.open(sound);
			clip.start();
		} catch (UnsupportedAudioFileException e) {
			JOptionPane.showMessageDialog(null,
					"Error al reproducir el archivo de audio.\nFormato no soportado por la aplicaci�n");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al manejar el archivo de audio");
		} catch (LineUnavailableException e) {
			JOptionPane.showMessageDialog(null,
					"Error al reproducir el archivo de audio.\nEst� siendo usado por otro programa");
		}
	}

	public JLabel getLblTimeHours() {
		return lblTimeHours;
	}

	public JLabel getLblTimeMinutes() {
		return lblTimeMinutes;
	}

	public JLabel getLblTimeSeconds() {
		return lblTimeSeconds;
	}

	public JLabel getLblChronoMinutes() {
		return lblChronoMinutes;
	}

	public JLabel getLblChronoSeconds() {
		return lblChronoSeconds;
	}

	public JLabel getLblCentiseconds() {
		return lblChronoCentiseconds;
	}

	public JSpinner getSpinnerTimerHours() {
		return spinnerTimerHours;
	}

	public JSpinner getSpinnerTimerMinutes() {
		return spinnerTimerMinutes;
	}

	public JSpinner getSpinnerTimerSeconds() {
		return spinnerTimerSeconds;
	}

	public JButton getBtnChronoReiniciar() {
		return btnChronoReset;
	}

	public JToggleButton getBtnChronoIniciar() {
		return btnChronoStartStop;
	}

	public JToggleButton getBtnTimerStartStop() {
		return btnTimerStartStop;
	}
}
