import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by 万运泽 on 2018/1/20.
 */
public class ValidPieceTest {
    @Test
    public void isPlacementWellFormedTest(){
        String placement1 = "A1";
        String placement2 = "B3";
        String placement3 = "K14";
        String placement4 = "O15";
        String placement5 = "P15";
        String placement6 = "A16";
        String placement7 = "777";
        String placement8 = "AAA";
        String placement9 = "A134";
        String placement10 = "=-]";
        assertTrue("Placement " + placement1 + "\' is well formed, but failed", ValidPieces.isPlacementWellFormed(placement1));
        assertTrue("Placement " + placement2 + "\' is well formed, but failed", ValidPieces.isPlacementWellFormed(placement2));
        assertTrue("Placement " + placement3 + "\' is well formed, but failed", ValidPieces.isPlacementWellFormed(placement3));
        assertTrue("Placement " + placement4 + "\' is well formed, but failed", ValidPieces.isPlacementWellFormed(placement4));
        assertFalse("Placement " + placement5 + "\' is badly formed, but passed", ValidPieces.isPlacementWellFormed(placement5));
        assertFalse("Placement " + placement6 + "\' is badly formed, but passed", ValidPieces.isPlacementWellFormed(placement6));
        assertFalse("Placement " + placement7 + "\' is badly formed, but passed", ValidPieces.isPlacementWellFormed(placement7));
        assertFalse("Placement " + placement8 + "\' is badly formed, but passed", ValidPieces.isPlacementWellFormed(placement8));
        assertFalse("Placement " + placement9 + "\' is badly formed, but passed", ValidPieces.isPlacementWellFormed(placement9));
        assertFalse("Placement " + placement10 + "\' is badly formed, but passed", ValidPieces.isPlacementWellFormed(placement10));
    }
    @Test
    public void isPlacementsWellFormedTest(){
        String simplePlacements = "A1B2C9K3B5O5";
        String HardPlacement = "B15O15B9K4E10";
        String simpleBadPlacement = "C9A4K6O15P13";
        String DupBadPlacement = "K8A15O15C9A4A8F6K8";
        String RandomBadPlacement = "hr2893f0pomng35i4fmo3";
        assertTrue("Placement " + simplePlacements + "\' is well formed, but failed", ValidPieces.isPlacementWellFormed(simplePlacements));
        assertTrue("Placement " + HardPlacement + "\' is well formed, but failed", ValidPieces.isPlacementWellFormed(HardPlacement));
        assertFalse("Placement " + simpleBadPlacement + "\' is badly formed, but passed", ValidPieces.isPlacementWellFormed(simpleBadPlacement));
        assertFalse("Placement " + DupBadPlacement + "\' is badly formed, but passed", ValidPieces.isPlacementWellFormed(DupBadPlacement));
        assertFalse("Placement " + RandomBadPlacement + "\' is badly formed, but passed", ValidPieces.isPlacementWellFormed(RandomBadPlacement));
    }
}
