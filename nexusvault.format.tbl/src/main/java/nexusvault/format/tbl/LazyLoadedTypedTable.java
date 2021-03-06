package nexusvault.format.tbl;

/**
 * Builds only table entries which are requested (no caching)
 *
 * @see AbstTypedTable
 */
public class LazyLoadedTypedTable<T> extends AbstTypedTable<T> {
	protected final RawTable table;

	public LazyLoadedTypedTable(Class<T> entryClass, RawTable table) {
		super(entryClass);
		this.table = table;
	}

	@Override
	public T getEntry(int recordIdx) {
		return buildRecord(table, recordIdx);
	}

	@Override
	public int size() {
		return table.size();
	}
}