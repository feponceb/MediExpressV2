@RestController
@RequestMapping("api/v1/resenas")
public class ResenaController {
    @Autowired
    private ResenaService resenaService;

    @Getmapping
    public ResponseEntity<List<Resena>> obtenerResenas() {
        List<Resena> resenas = resenaService.getResenas();
        if (resenas.isEmpty()) {
            return new ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(resenas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resena> obtenerResenas (@PathVariable Long id) {
        try {
            Resena resena = resenaService.getResena(id);
            return ResponseEntity.ok(resena);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public ResponseEntity<Resena> guardarResena(@RequestBody Resena nueva) {
        return ResponseEntity.status(201).body(resenaService.saveResena(nueva));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarResena(@PathVariable Long id) {
        resenaService.deleteResena(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resena> actualizarResena(@PathVariable Long id, @RequestBody Resena resena) {
        try {
            Resena resenaActualizada = resenaService.updateResena(id, resena);
            return ResponseEntity.ok(resenaActualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
