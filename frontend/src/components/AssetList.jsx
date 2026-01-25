import React from 'react';

function AssetList({ assets, loading, error, role, onEdit, onDelete }) {

    const isAdmin = role === 'ADMIN';

    if (loading) return <div>Loading assets...</div>;
    if (error) return <div style={{ color: 'red' }}>{error}</div>;

    if (!assets || assets.length === 0) {
        return <div>No assets found.</div>;
    }

    return (
        <div>
            <h2>Assets</h2>

            <table border="1" cellPadding="8" cellSpacing="0">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Category</th>
                        <th>Purchase Date</th>
                        <th>Status</th>
                        <th>E-Waste</th>
                        {isAdmin && <th>Actions</th>}
                    </tr>
                </thead>

                <tbody>
                    {assets.map(asset => (
                        <tr key={asset.assetId}>
                            <td>{asset.assetName}</td>
                            {/* <td>{asset.category?.categoryName}</td> */}
                            <td>N/A</td>
                            <td>{asset.purchaseDate}</td>
                            <td>{asset.status}</td>
                            <td>{asset.status === 'DAMAGED' ? 'Yes' : 'No'}</td>

                            {isAdmin && (
                                <td>
                                    <button onClick={() => onEdit(asset)}>
                                        Edit
                                    </button>

                                    <button
                                        onClick={() => {
                                            if (window.confirm('Delete this asset?')) {
                                                onDelete(asset.assetId);
                                            }
                                        }}
                                        style={{ marginLeft: '8px' }}
                                    >
                                        Delete
                                    </button>
                                </td>
                            )}
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
}

export default AssetList;
