package ProgettoAzzardo;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseAdapter;

public class ProgettoAzzardoGrafica {
	Image[] immagini = new Image[7];
	Label lblSimbolo1, lblSimbolo2, lblSimbolo3;
	int credit=1000;
	int bet=0;
	int cash=0;
	int punti=0;
	int n = 0;
	int soldi = 0;
	int ok = 0;
	protected Shell shlNardisSlot;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			ProgettoAzzardoGrafica window = new ProgettoAzzardoGrafica();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlNardisSlot.open();
		shlNardisSlot.layout();
		while (!shlNardisSlot.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlNardisSlot = new Shell();
		shlNardisSlot.setImage(SWTResourceManager.getImage("immagini\\slot.png"));

		shlNardisSlot.setSize(645, 644);
		shlNardisSlot.setText("NARDI'S SLOT");

		// diamo ad ogni spazio del vettore un'immagine

		immagini[0] = new Image(null, "immagini/mela.png");
		immagini[1] = new Image(null, "immagini/diamante.png");
		immagini[2] = new Image(null, "immagini/campana.png");
		immagini[3] = new Image(null, "immagini/anguria.png");
		immagini[4] = new Image(null, "immagini/sette.png");
		immagini[5] = new Image(null, "immagini/fragola.png");
		immagini[6] = new Image(null, "immagini/corona.png");
		
		

		// fine dichiarazione immagine
		

		
		
		
		Label label2 = new Label(shlNardisSlot, SWT.NONE);
		label2.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		label2.setBounds(135, 425, 57, 37);
		label2.setText("Credit:");
		
		Label lblCredit = new Label(shlNardisSlot, SWT.NONE);
		lblCredit.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblCredit.setBounds(192, 425, 79, 37);
		lblCredit.setText("1000");
		
		Label lblBet = new Label(shlNardisSlot, SWT.NONE);
		lblBet.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblBet.setBounds(325, 425, 66, 37);
		lblBet.setText("0");
		
		Label label4 = new Label(shlNardisSlot, SWT.NONE);
		label4.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		label4.setBounds(157, 502, 68, 30);
		label4.setText("Win:");
		
		Label lblCash = new Label(shlNardisSlot, SWT.NONE);
		lblCash.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblCash.setBounds(225, 502, 68, 30);
		lblCash.setText("0");
		
		Label lblNewLabel_1 = new Label(shlNardisSlot, SWT.NONE);
		lblNewLabel_1.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblNewLabel_1.setBounds(270, 425, 56, 37);
		lblNewLabel_1.setText("Bet:");

		Label lblSimbolo2 = new Label(shlNardisSlot, SWT.BORDER);
		lblSimbolo2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblSimbolo2.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblSimbolo2.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		lblSimbolo2.setBounds(246, 269, 109, 153);

		Label lblSimbolo1 = new Label(shlNardisSlot, SWT.BORDER);
		lblSimbolo1.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblSimbolo1.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		lblSimbolo1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblSimbolo1.setBounds(135, 269, 109, 153);

		Label lblSimbolo3 = new Label(shlNardisSlot, SWT.BORDER);
		lblSimbolo3.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblSimbolo3.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		lblSimbolo3.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblSimbolo3.setBounds(361, 269, 109, 153);

		Label lblNewLabel = new Label(shlNardisSlot, SWT.NONE);
		lblNewLabel.setAlignment(SWT.CENTER);
		lblNewLabel.setFont(SWTResourceManager.getFont("Txt", 24, SWT.NORMAL));
		lblNewLabel.setBounds(59, 10, 497, 54);
		lblNewLabel.setText("NARDI'S SLOT MACHINE");

		Label lblSpin = new Label(shlNardisSlot, SWT.BORDER);
		
		lblSpin.setEnabled(false);
		
		Button btnBetMax = new Button(shlNardisSlot, SWT.NONE);
		btnBetMax.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(credit>0){
					lblSpin.setEnabled(true);
					bet=credit;
					lblBet.setText(""+bet);
				}else{
					lblSpin.setEnabled(false);
					JOptionPane.showMessageDialog(null,"Non c'è niente da scommettere","Errore",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnBetMax.setBounds(157, 531, 137, 25);
		btnBetMax.setText("Bet max");

		lblSpin.addMouseListener(new MouseAdapter() {
			
			@Override
			
			public void mouseDown(MouseEvent e) {
				credit=credit-bet;
				if(credit < 0){
					credit=credit+bet;
					ok=1;
					JOptionPane.showMessageDialog(null,"Fondi insufficienti","Errore",JOptionPane.ERROR_MESSAGE);
				}
				else{
				ok=0;
				lblCredit.setText(""+credit);
				lblCash.setText("0");
				lblSpin.setEnabled(false);
				}
				Thread thread = new Thread() {
					@Override
					public void run() {
						// lblSpin.setBackground(SWTResourceManager.getColor(SWT.COLOR_YELLOW));

						for (int i = 0; i < 7; i++) {

							n = (int) (Math.random() * 7);
							//System.out.println(i);
							Display.getDefault().asyncExec(new Runnable() {
								public void run() {
									// ora le immagini cambiano
									lblSimbolo1.setImage(immagini[n]);

								}
							});
							try {
								Thread.sleep(100);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						Display.getDefault().asyncExec(new Runnable() {

							@Override
							public void run() {
								// TODO Auto-generated method stub
								//condizione di vittoria
								if(lblSimbolo1.getImage()==lblSimbolo2.getImage()&&lblSimbolo2.getImage()==lblSimbolo3.getImage()&&lblSimbolo1.getImage()==lblSimbolo3.getImage()){
									if(lblSimbolo1.getImage()==immagini[0]){
										punti=10; //mela
									}
									if(lblSimbolo1.getImage()==immagini[1]){
										punti=80; //diamante
									}
									if(lblSimbolo1.getImage()==immagini[2]){
										punti=40; //campana
									}
									if(lblSimbolo1.getImage()==immagini[3]){
										punti=20; //anguria
									}
									if(lblSimbolo1.getImage()==immagini[4]){
										punti=100; //sette
									}
									if(lblSimbolo1.getImage()==immagini[5]){
										punti=30; //fragola
									}
									if(lblSimbolo1.getImage()==immagini[6]){
										punti=60; //corona
									}
									cash=punti*bet;
									lblCash.setText(""+cash);
									credit=credit+cash;
									lblCredit.setText(""+credit);
									
								}
								
								
								
								lblSpin.setEnabled(true);
							}

						});
					}
				};

				Thread thread2 = new Thread() {
					@Override
					public void run() {
						// lblSpin.setBackground(SWTResourceManager.getColor(SWT.COLOR_YELLOW));

						for (int i = 0; i < 7; i++) {
							n = (int) (Math.random() * 7);
							//System.out.println(i);
							Display.getDefault().asyncExec(new Runnable() {
								public void run() {
									// ora le immagini cambiano

									lblSimbolo2.setImage(immagini[n]);

								}
							});
							try {
								Thread.sleep(50);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}

					}

				};

				// p.CambioImmagine(100);

				Thread thread3 = new Thread() {
					@Override
					public void run() {
						// lblSpin.setBackground(SWTResourceManager.getColor(SWT.COLOR_YELLOW));

						for (int i = 0; i < 7; i++) {
							n = (int) (Math.random() * 7);
							//System.out.println(i);
							Display.getDefault().asyncExec(new Runnable() {
								public void run() {
									// ora le immagini cambiano

									lblSimbolo3.setImage(immagini[n]);

								}
							});
							try {
								Thread.sleep(60);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}

				};
				if(ok == 0){
					thread.start();
					thread2.start();
					thread3.start();
				}
			}

			public void mouseUp(MouseEvent e) {
				lblSpin.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
			}
		});
		lblSpin.setAlignment(SWT.CENTER);
		lblSpin.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				lblSpin.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
			}

			public void mouseExit(MouseEvent e) {
				lblSpin.setBackground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
			}
		});
		lblSpin.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		lblSpin.setBackground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
		lblSpin.setImage(SWTResourceManager.getImage(ProgettoAzzardoGrafica.class, "/ProgettoAzzardo/PlayNow.png"));
		lblSpin.setBounds(391, 425, 76, 37);
		lblSpin.setText("SPIN");
		
		
		
		Button buttonpiu = new Button(shlNardisSlot, SWT.NONE);
		buttonpiu.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		buttonpiu.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(bet<credit){
					ok=0;
					lblSpin.setEnabled(true);
					bet++;
					lblBet.setText(""+bet);
				}
			}
		});
		buttonpiu.setBounds(325, 502, 51, 54);
		buttonpiu.setText("+");
		
		Button buttonmeno = new Button(shlNardisSlot, SWT.NONE);
		buttonmeno.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		buttonmeno.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(bet<credit){
					ok=0;
				}
				if(bet>0){
					bet--;
					lblBet.setText(""+bet);
				}
				if(bet==0){
					lblSpin.setEnabled(false);
				}
				
			}
		});
		buttonmeno.setText("-");
		buttonmeno.setBounds(400, 502, 51, 54);
		
		Label label = new Label(shlNardisSlot, SWT.NONE);
		label.setAlignment(SWT.CENTER);
		label.setImage(SWTResourceManager.getImage("immagini\\slot.png"));
		label.setBounds(0, 80, 616, 506);

	}

	public Image[] getImmagini() {
		return immagini;
	}

	public void setImmagini(Image[] immagini) {
		this.immagini = immagini;
	}
}
