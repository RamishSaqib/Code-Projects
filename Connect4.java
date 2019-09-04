import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class Connect4 extends JFrame {
    private static int size = 600;
    private static int n = 10;
    private static int ovalSize = size/7 - n*2;
    private static int pos = n/5;
    private static int inc = size/7;

    public static void main( String[] args ) throws Exception {
        SwingUtilities.invokeLater( new Runnable() {
            public void run() { new Connect4(); }
        } );
    }

    public Connect4() {
        super( "CompositeBoardTest" );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        Board board = new Board();
        getContentPane().add( board );
        setSize( size, size+74 );
        setVisible( true );
    }


    static class Board extends JPanel implements ActionListener {
        private int[][] pieces = new int[6][7];
        private Piece addPiece = null;
        private Timer droppedPiece = null;

        public Board() {
            setPreferredSize(new Dimension(size, size));
            setBounds(0, 0, size, size);
            droppedPiece = new Timer(20, this);
            addMouseListener(new MouseAdapter() {
                public void mousePressed( MouseEvent e ) {
                    int column = (e.getPoint().x-pos)/inc;
                    addPiece(column);
                }
            });
        }

        protected void paintComponent( Graphics g ) {
            super.paintComponent( g );

            Graphics2D g2D = (Graphics2D) g;
            Composite comp = g2D.getComposite();

            Dimension d = getSize();
            int w = d.width;
            int h = d.height;

            BufferedImage buffImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
            Graphics2D gbi = buffImage.createGraphics();

            g2D.setColor( Color.WHITE );
            g2D.fillRect( 0, 0, w, h );

            gbi.setColor( Color.YELLOW );
            gbi.setColor( Color.BLUE );
            gbi.fillRect( 0, 0, w, h );

            gbi.setColor( Color.RED );
            for ( int row = 0 ; row < 6 ; row++ ) {
                for ( int column = 0 ; column < 7 ; column++ ) {
                    if ( pieces[row][column] == 1 ) {
                        gbi.setComposite( AlphaComposite.getInstance( AlphaComposite.SRC_OVER, .1f ) );
                    } else {
                        gbi.setComposite( AlphaComposite.getInstance( AlphaComposite.CLEAR, 0.5f ) );
                    }
                    gbi.fillOval( inc*column+pos, inc*row+pos, ovalSize, ovalSize );
                }
            }

            if ( addPiece != null ) {
                gbi.setComposite( AlphaComposite.getInstance( AlphaComposite.DST_OVER, 1.0f ) );
                gbi.fillOval( addPiece.x, addPiece.y, ovalSize, ovalSize );
            }

            g2D.drawImage(buffImage, null, 0, 0);

        }

        public void addPiece( int column ) {
            if ( addPiece == null ) {
                if ( pieces[0][column] == 0 ) {
                    addPiece = new Piece();
                    addPiece.row = 0;
                    addPiece.column = column;
                    addPiece.x = inc*column+pos;
                    addPiece.y = 0;
                    droppedPiece.start();
                } 
            }
        }

        public void actionPerformed( ActionEvent e ) {
            if ( addPiece != null ) {
                addPiece.y += 5;
                int row = ( addPiece.y - pos )/inc + 1;
                if ( row > 5 || pieces[row][addPiece.column] == 1 ) {
                    pieces[row-1][addPiece.column] = 1;
                    addPiece = null;
                    droppedPiece.stop();
                }
            }
            repaint();
        }
    }

    private static class Piece {
        public int row, column, x, y;
    }
}