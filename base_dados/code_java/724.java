import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayList;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.Collections;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author BSRK Aditya
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        EColoredCubes solver = new EColoredCubes();
        solver.solve(1, in, out);
        out.close();
    }

    static class EColoredCubes {
        int boardSz;
        int numCubes;
        Pos[] initPos;
        Pos[] finalPos;

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            boardSz = in.readInt();
            numCubes = in.readInt();
            initPos = new Pos[numCubes + 1];
            initPos[0] = new Pos(0, 0, 0);
            for (int i = 1; i <= numCubes; ++i) {
                initPos[i] = new Pos(in.readInt(), in.readInt(), i);
            }

            finalPos = new Pos[numCubes + 1];
            finalPos[0] = new Pos(0, 0, 0);
            for (int i = 1; i <= numCubes; ++i) {
                finalPos[i] = new Pos(in.readInt(), in.readInt(), i);
            }

            ArrayList<Move> ansP1 = toBasic(initPos);
            ArrayList<Move> ansP2 = toBasic(finalPos);
            Collections.reverse(ansP2);

            out.printLine(ansP1.size() + ansP2.size());
            for (Move m : ansP1) {
                out.printLine(m.start.x, m.start.y, m.end.x, m.end.y);
            }
            for (Move m : ansP2) {
                out.printLine(m.end.x, m.end.y, m.start.x, m.start.y);
            }
        }

        ArrayList<Move> toBasic(Pos[] pos) {
            Arrays.sort(pos, new Comparator<Pos>() {

                public int compare(Pos o1, Pos o2) {
                    if (o1.x < o2.x) return -1;
                    if (o1.x > o2.x) return 1;
                    if (o1.y < o2.y) return -1;
                    if (o1.y > o2.y) return 1;
                    return 0;
                }
            });

            boolean[][] board = new boolean[boardSz + 1][boardSz + 1];
            for (int i = 0; i <= boardSz; ++i)
                for (int j = 0; j <= boardSz; ++j)
                    board[i][j] = false;
            for (int i = 1; i <= numCubes; ++i)
                board[pos[i].x][pos[i].y] = true;

            ArrayList<Move> moves = new ArrayList<>();

            boolean allDone = false;
            while (!allDone) {
                allDone = true;
                for (int i = 1; i <= numCubes; ++i) {
                    // set pos[i].x to i
                    boolean canMove = true;
                    while (pos[i].x != i && canMove) {
                        allDone = false;
                        Pos nPos = new Pos(pos[i].x - (int) Math.signum(pos[i].x - i), pos[i].y, pos[i].cn);
                        if (!board[nPos.x][nPos.y]) {
                            moves.add(new Move(pos[i], nPos));
                            board[pos[i].x][pos[i].y] = false;
                            board[nPos.x][nPos.y] = true;
                            pos[i] = nPos;
                        } else canMove = false;
                    }
                }
            }

            for (int i = 1; i <= numCubes; ++i) {
                while (pos[i].y != pos[i].cn) {
                    Pos nPos = new Pos(pos[i].x, pos[i].y - (int) Math.signum(pos[i].y - pos[i].cn), pos[i].cn);
                    moves.add(new Move(pos[i], nPos));
                    pos[i] = nPos;
                }
            }

            for (int i = 1; i <= numCubes; ++i) {
                while (pos[i].x != pos[i].cn) {
                    Pos nPos = new Pos(pos[i].x - (int) Math.signum(pos[i].x - pos[i].cn), pos[i].y, pos[i].cn);
                    moves.add(new Move(pos[i], nPos));
                    pos[i] = nPos;
                }
            }

            return moves;
        }

        class Pos {
            final int x;
            final int y;
            final int cn;

            Pos(int x, int y, int cn) {
                this.x = x;
                this.y = y;
                this.cn = cn;
            }

        }

        class Move {
            final Pos start;
            final Pos end;

            Move(Pos start, Pos end) {
                this.start = start;
                this.end = end;
            }

        }

    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0)
                    writer.print(' ');
                writer.print(objects[i]);
            }
        }

        public void printLine(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int readInt() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}

